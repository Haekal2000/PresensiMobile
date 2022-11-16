package com.example.aplikasipresensi.ui.auth.views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import com.example.aplikasipresensi.api.UserApi
import com.example.aplikasipresensi.base.BaseActivity
import com.example.aplikasipresensi.databinding.ActivityMainBinding
import com.example.aplikasipresensi.network.Resource
import com.example.aplikasipresensi.preferences.DataPreferences
import com.example.aplikasipresensi.repository.UserRepository
import com.example.aplikasipresensi.requests.UserRequest
import com.example.aplikasipresensi.ui.auth.viewmodel.UserViewModel
import com.example.aplikasipresensi.ui.home.views.HomeActivity
import com.example.aplikasipresensi.util.CORE_BASE_URL

class MainActivity : BaseActivity<ActivityMainBinding>() {
    lateinit var viewModelUser: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setInit()
        initView()
        initAction()
    }

    fun setInit() {
        val userRepo = UserRepository(remotedDataSource.buildApi(UserApi::class.java, CORE_BASE_URL), DataPreferences(applicationContext))
        viewModelUser = UserViewModel(userRepo)
    }

    fun initView() {
        viewModelUser.userResponse.observe(this) {
            when (it) {
                is Resource.Success -> {
                    it.value.data?.token?.let { it1 -> viewModelUser.setToken(it1) }
                    it.value.data?.userData?.nrpId?.let { it2 -> viewModelUser.setNrpId(it2) }
                    it.value.data?.userData?.name?.let { it3 -> viewModelUser.setName(it3) }
                    it.value.data?.userData?.departmentId?.let { it4 -> viewModelUser.setDepartmentId(it4) }
                    it.value.data?.userData?.academicPeriodId?.let { it5 -> viewModelUser.setAcademicPeriodId(it5) }
                    goToActivityClearAllStack(HomeActivity::class.java, null)
                    Log.e("tokenTesting", it.value.data?.token.toString())
                    Log.e("NRPID", it.value.data?.userData?.nrpId.toString())
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
        }
    }

    override fun getActivityBinding(layoutInflater: LayoutInflater) = ActivityMainBinding.inflate(layoutInflater)
}