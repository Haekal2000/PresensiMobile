package com.example.aplikasipresensi.ui.teacherAuth.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.lifecycle.asLiveData
import com.example.aplikasipresensi.adapter.TeacherCourseAdapterTesting
import com.example.aplikasipresensi.api.TeacherDataApi
import com.example.aplikasipresensi.api.TeacherUserApi
import com.example.aplikasipresensi.base.BaseActivity
import com.example.aplikasipresensi.databinding.ActivityCodeScannerBinding
import com.example.aplikasipresensi.databinding.ActivityTeacherLoginBinding
import com.example.aplikasipresensi.network.Resource
import com.example.aplikasipresensi.preferences.DataPreferences
import com.example.aplikasipresensi.repository.TeacherDataRepository
import com.example.aplikasipresensi.repository.TeacherUserRepository
import com.example.aplikasipresensi.requests.TeacherUserRequest
import com.example.aplikasipresensi.ui.auth.views.MainActivity
import com.example.aplikasipresensi.ui.teacherAuth.viewmodel.TeacherDataViewModel
import com.example.aplikasipresensi.ui.teacherAuth.viewmodel.TeacherUserViewModel
import com.example.aplikasipresensi.ui.teacherHome.views.TeacherHomeActivity
import com.example.aplikasipresensi.util.CORE_BASE_URL

class TeacherLoginActivity : BaseActivity<ActivityTeacherLoginBinding>() {
    lateinit var viewModelTeacherUser: TeacherUserViewModel
    lateinit var viewModelTeacherData: TeacherDataViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setInit()
        initView()
        initAction()
    }

    fun setInit() {
        val teacherUserRepo = TeacherUserRepository(remotedDataSource.buildApi(TeacherUserApi::class.java, CORE_BASE_URL), DataPreferences(applicationContext))
        viewModelTeacherUser = TeacherUserViewModel(teacherUserRepo)

        val teacherDataRepo = TeacherDataRepository(remotedDataSource.buildApi(TeacherDataApi::class.java, CORE_BASE_URL), DataPreferences(applicationContext))
        viewModelTeacherData = TeacherDataViewModel(teacherDataRepo)
    }

    fun initView() {
        viewModelTeacherUser.teacherUserResponse.observe(this) {
            when (it) {
                is Resource.Success -> {
                    it.value.data?.token?.let { it1 -> viewModelTeacherUser.setToken(it1) }
                    goToActivityClearAllStack(TeacherHomeActivity::class.java, null)
                    Log.e("tokenTeacher", it.value.data?.token.toString())
                }
                is Resource.Failure -> {
                    if(it.errorCode == 400) {
                        bind.tilPassword.error = "NIK dan Password tidak cocok"
                    }
                }
            }
        }
    }

    fun initAction() {
        bind.btnLogin.setOnClickListener {
            var request = TeacherUserRequest()
            request.nik = bind.etNik.text.toString().trim()
            request.password = bind.etPassword.text.toString().trim()
            viewModelTeacherUser.teacherLogin(request)
            viewModelTeacherData.getTeacherData(bind.etNik.text.toString())
            prefs.getToken.asLiveData().observe(this) {
                viewModelTeacherData.teacherDataResponse.observe(this) {
                    when (it) {
                        is Resource.Success -> {
                            it.value.data?.name?.let { it2 -> viewModelTeacherData.setName(it2) }
                            it.value.data?.nik?.let { it3 -> viewModelTeacherData.setNik(it3) }
                            it.value.data?.departmentId?.let { it4 -> viewModelTeacherData.setDepartmentId(it4) }
                            Log.e("Data Teacher Berhasil", it.toString())
                        }
                        is Resource.Failure -> {
                            Log.e("Data Teacher GAGAL", it.toString())
                        }
                    }
                }
            }
        }

        bind.tvLoginAsStudent.setOnClickListener {
            goToActivityClearAllStack(MainActivity::class.java, null)
        }
    }

    override fun getActivityBinding(layoutInflater: LayoutInflater) = ActivityTeacherLoginBinding.inflate(layoutInflater)
}