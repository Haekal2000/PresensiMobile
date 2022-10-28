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
//    lateinit var viewModelStudent: StudentViewModel
//    private lateinit var studentAdapter: StudentAdapter
//
//    val temporaryStudent = mutableListOf<StudentModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setInit()
        initView()
        initAction()
    }

    fun setInit() {
        val userRepo = UserRepository(remotedDataSource.buildApi(UserApi::class.java, CORE_BASE_URL), DataPreferences(applicationContext))
        viewModelUser = UserViewModel(userRepo)

//        val studentRepo = StudentRepository(remotedDataSource.buildApi(StudentApi::class.java, CORE_BASE_URL), DataPreferences(applicationContext))
//        viewModelStudent = StudentViewModel(studentRepo)
    }

    fun initView() {
        viewModelUser.userResponse.observe(this) {
            when (it) {
                is Resource.Success -> {
                    it.value.data?.token?.let { it1 -> viewModelUser.setToken(it1) }
                    it.value.data?.userData?.nrpId?.let { it2 -> viewModelUser.setNrpId(it2) }
                    goToActivityClearAllStack(HomeActivity::class.java, null)
                    Log.e("tokenTesting", it.value.data?.token.toString())
                    Log.e("NRPID", it.value.data?.userData?.nrpId.toString())
                }
                is Resource.Failure -> {
                    if (it.errorCode == 500) {
                        bind.tilPassword.error = "NRP dan Password tidak cocok"
                    }
                }
            }
        }
    }

    fun initAction() {
        bind.btnLogin.setOnClickListener {
            var request = UserRequest()
            var nrp = bind.etNrp.text.toString().trim()
            request.nrpId = bind.etNrp.text.toString().trim()
            request.password = bind.etPassword.text.toString().trim()
            viewModelUser.login(request)

//            viewModelStudent.getListStudent(1973009)
//            viewModelStudent.studentResponse.observe(this) {
//                when (it) {
//                    is Resource.Success -> {
////                    studentAdapter.setStudent(it.value.data!!)
////                    Log.e("adapterrrrr", it.value.data!!.toString())
//                        it.value.data?.name?.let { it2 -> viewModelStudent.setName(it2) }
//                        it.value.data?.nrpId?.let { it3 -> viewModelStudent.setNrpId(it3) }
////                        it.value.data?.let { it2 -> studentAdapter.setStudent(it2) }
//                        Log.e("adapterrrrrerereasd", it.value.data?.name.toString())
//                        Snackbar.make(bind.llMainActivity, "NRP BENER", Snackbar.LENGTH_LONG).show()
//                    }
//                    is Resource.Failure -> {
//                        Snackbar.make(bind.llMainActivity, "NRP SALAH", Snackbar.LENGTH_LONG).show()
//                    }
//                }
//            }
        }

//        bind.etNrp.addTextChangedListener(object:TextWatcher{
//            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//            }
//
//            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//            }
//
//            override fun afterTextChanged(p0: Editable?) {
//                if (bind.etNrp.text.toString() == temporaryStudent[0].nrpId) {
//
//                }
//            }
//
//        })
    }

    override fun getActivityBinding(layoutInflater: LayoutInflater) = ActivityMainBinding.inflate(layoutInflater)
}