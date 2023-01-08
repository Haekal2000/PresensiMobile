package com.example.aplikasipresensi.ui.auth.views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.lifecycle.asLiveData
import com.example.aplikasipresensi.api.StudentDataApi
import com.example.aplikasipresensi.api.UserApi
import com.example.aplikasipresensi.base.BaseActivity
import com.example.aplikasipresensi.databinding.ActivityMainBinding
import com.example.aplikasipresensi.network.Resource
import com.example.aplikasipresensi.preferences.DataPreferences
import com.example.aplikasipresensi.repository.StudentDataRepository
import com.example.aplikasipresensi.repository.UserRepository
import com.example.aplikasipresensi.requests.UserRequest
import com.example.aplikasipresensi.ui.auth.viewmodel.StudentDataViewModel
import com.example.aplikasipresensi.ui.auth.viewmodel.UserViewModel
import com.example.aplikasipresensi.ui.home.views.HomeActivity
import com.example.aplikasipresensi.ui.teacherAuth.views.TeacherLoginActivity
import com.example.aplikasipresensi.util.CORE_BASE_URL
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

class MainActivity : BaseActivity<ActivityMainBinding>() {
    lateinit var viewModelUser: UserViewModel
    lateinit var viewModelStudentData: StudentDataViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setInit()
        initView()
        initAction()
    }

    fun setInit() {
        val userRepo = UserRepository(remotedDataSource.buildApi(UserApi::class.java, CORE_BASE_URL), DataPreferences(applicationContext))
        viewModelUser = UserViewModel(userRepo)

        val studentDataRepo = StudentDataRepository(remotedDataSource.buildApi(StudentDataApi::class.java, CORE_BASE_URL), DataPreferences(applicationContext))
        viewModelStudentData = StudentDataViewModel(studentDataRepo)
    }

    fun initView() {
        viewModelUser.userResponse.observe(this) {
            when (it) {
                is Resource.Success -> {
                    it.value.data?.token?.let { it1 -> viewModelUser.setToken(it1) }
                    goToActivityClearAllStack(HomeActivity::class.java, null)
                    Log.e("tokenTesting", it.value.data?.token.toString())
                }
                is Resource.Failure -> {
                    if (it.errorCode == 400) {
                        bind.tilPassword.error = "NRP dan Password tidak cocok"
                    }
                }
            }
        }
    }

    fun initAction() {
        bind.btnLogin.setOnClickListener {
            var request = UserRequest()
            request.nrpId = bind.etNrp.text.toString().trim()
            request.password = bind.etPassword.text.toString().trim()
            viewModelUser.login(request)
            viewModelStudentData.getStudentData(bind.etNrp.text.toString())
            prefs.getToken.asLiveData().observe(this) {
            viewModelStudentData.studentDataResponse.observe(this) {
                when (it) {
                    is Resource.Success -> {
                        it.value.data?.nrpId?.let { it2 -> viewModelStudentData.setNrpId(it2) }
                        it.value.data?.name?.let { it3 -> viewModelStudentData.setName(it3) }
                        it.value.data?.departmentId?.let { it4 -> viewModelStudentData.setDepartmentId(it4) }
                        it.value.data?.academicPeriodId?.let { it5 -> viewModelStudentData.setAcademicPeriodId(it5) }
                        Log.e("Data Student Berhasil", it.toString())
                    }
                    is Resource.Failure -> {
                        Log.e("Data Student GAGAL", it.toString())
                    }
                }
            }
            }
        }

        bind.tvLoginAsTeacher.setOnClickListener {
            goToActivityClearAllStack(TeacherLoginActivity::class.java, null)
        }
    }

    override fun getActivityBinding(layoutInflater: LayoutInflater) = ActivityMainBinding.inflate(layoutInflater)
}