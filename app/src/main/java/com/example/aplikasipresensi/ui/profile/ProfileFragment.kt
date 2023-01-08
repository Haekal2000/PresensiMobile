package com.example.aplikasipresensi.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.aplikasipresensi.api.TeacherUserApi
import com.example.aplikasipresensi.api.UserApi
import com.example.aplikasipresensi.base.BaseFragment
import com.example.aplikasipresensi.databinding.FragmentProfileBinding
import com.example.aplikasipresensi.preferences.DataPreferences
import com.example.aplikasipresensi.repository.TeacherUserRepository
import com.example.aplikasipresensi.repository.UserRepository
import com.example.aplikasipresensi.ui.auth.views.MainActivity
import com.example.aplikasipresensi.util.CORE_BASE_URL
import com.example.aplikasipresensi.ui.auth.viewmodel.UserViewModel
import com.example.aplikasipresensi.ui.teacherAuth.viewmodel.TeacherUserViewModel

class ProfileFragment : BaseFragment<FragmentProfileBinding>() {
    lateinit var viewModelUser: UserViewModel
    lateinit var viewModelTeacher: TeacherUserViewModel

//    val layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setInit()
        initAction()
    }

    fun setInit() {
        val userRepo = UserRepository(remoteDataSource.buildApi(UserApi::class.java, CORE_BASE_URL), DataPreferences(requireContext()))
        viewModelUser = UserViewModel(userRepo)

        val teacherRepo = TeacherUserRepository(remoteDataSource.buildApi(TeacherUserApi::class.java, CORE_BASE_URL), DataPreferences(requireContext()))
        viewModelTeacher = TeacherUserViewModel(teacherRepo)
    }

    fun initAction() {
        bind.btnExit.setOnClickListener {
            viewModelUser.setToken("")
            viewModelTeacher.setToken("")
            goToActivityClearAllStack(MainActivity::class.java, null)
        }
    }

    override fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?) = FragmentProfileBinding.inflate(inflater,container, false)

}