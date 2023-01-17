package com.example.aplikasipresensi.ui.teacherHome.views

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aplikasipresensi.adapter.TeacherCourseAdapter
import com.example.aplikasipresensi.adapter.TeacherCourseAdapterTesting
import com.example.aplikasipresensi.api.SendEmailApi
import com.example.aplikasipresensi.api.TeacherCourseApi
import com.example.aplikasipresensi.base.BaseFragment
import com.example.aplikasipresensi.databinding.FragmentTeacherBinding
import com.example.aplikasipresensi.listener.OnItemClickListener
import com.example.aplikasipresensi.model.teacher.TeacherCourseModel
import com.example.aplikasipresensi.network.RemoteDataSource
import com.example.aplikasipresensi.network.Resource
import com.example.aplikasipresensi.preferences.DataPreferences
import com.example.aplikasipresensi.repository.SendEmailRepository
import com.example.aplikasipresensi.repository.TeacherCourseRepository
import com.example.aplikasipresensi.requests.SendEmailRequest
import com.example.aplikasipresensi.ui.auth.views.MainActivity
import com.example.aplikasipresensi.ui.teacherHome.viewmodel.TeacherCourseViewModel
import com.example.aplikasipresensi.ui.teacherHome.viewmodel.SendEmailViewModel
import com.example.aplikasipresensi.util.CORE_BASE_URL
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

class TeacherFragment: BaseFragment<FragmentTeacherBinding>() {
    private lateinit var teacherCourseAdapter: TeacherCourseAdapter
    private lateinit var teacherCourseAdapterTesting: TeacherCourseAdapterTesting
    private lateinit var listTeacherCourse: MutableList<TeacherCourseModel>
    lateinit var viewModelSendEmail: SendEmailViewModel
    lateinit var viewModelTeacherCourse: TeacherCourseViewModel
    val temporaryTeacherCourse = mutableListOf<TeacherCourseModel>()
    val teacherCourseLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

//    companion object {
//        private lateinit var teacherFragment: TeacherFragment
//
//        fun newInstance(): TeacherFragment {
//            teacherFragment = TeacherFragment()
//            return teacherFragment
//        }
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        listTeacherCourse = ArrayList()
//        teacherCourseAdapter = TeacherCourseAdapter(listTeacherCourse)
//        teacherCourseAdapter = TeacherCourseAdapter(mutableListOf())
//        teacherCourseAdapter.setItemDataListener(object : TeacherCourseAdapter.ItemDataListener {
//            override fun itemDataClicked(teacherCourse : TeacherCourseModel) {
//                var request = SendEmailRequest()
//                request.courseId = "IN210"
//                request.academicPeriodId = "28104643-57bb-466b-9a68-091f3322c450"
//                request.departmentId = "46c0d3ec-0063-4f26-8f14-6be3bbe99f07"
//                request.courseName = "Web Dasar"
//                viewModelSendEmail.sendEmail(request)
//                viewModelSendEmail.sendEmailResponse.observe(requireActivity()) {
//                    when(it) {
//                        is Resource.Success -> {
//                            Snackbar.make(bind.llTeacherFragment, "Email Telah Terkirim", Snackbar.LENGTH_SHORT).show()
//                        }
//
//                        is Resource.Failure -> {
//                            Log.e("guagal", it.toString())
//                            Snackbar.make(bind.llTeacherFragment, "Email Gagal Terkirim", Snackbar.LENGTH_SHORT).show()
//                        }
//                    }
//                }
//            }
//        })
//    }
//
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        bind = FragmentTeacherBinding.inflate(inflater, container, false)
//        remoteDataSource = RemoteDataSource(requireActivity())
//        prefs = DataPreferences(requireActivity())
//        teacherCourseAdapter = TeacherCourseAdapter(listTeacherCourse)
//
//        val sendEmailRepo = SendEmailRepository(remoteDataSource.buildApi(SendEmailApi::class.java, CORE_BASE_URL))
//        viewModelSendEmail = SendEmailViewModel(sendEmailRepo)
//
//        val teacherCourseRepo = TeacherCourseRepository(remoteDataSource.buildApi(TeacherCourseApi::class.java, CORE_BASE_URL))
//        viewModelTeacherCourse = TeacherCourseViewModel(teacherCourseRepo)

        // send email testing
//        teacherCourseAdapter.setTeacherCourse(temporaryTeacherCourse)
//        var request = SendEmailRequest()
////        request.courseId = "IN210"
////        request.academicPeriodId = "28104643-57bb-466b-9a68-091f3322c450"
////        request.departmentId = "46c0d3ec-0063-4f26-8f14-6be3bbe99f07"
////        request.courseName = "Web Dasar"
//        request.courseId = temporaryTeacherCourse[0].courseId.toString().trim()
//        request.academicPeriodId = temporaryTeacherCourse[0].academicPeriodId.toString().trim()
//        request.departmentId = temporaryTeacherCourse[0].course?.departmentId.toString().trim()
//        request.courseName = temporaryTeacherCourse[0].course?.name.toString().trim()
//        viewModelSendEmail.sendEmail(request)
//        viewModelSendEmail.sendEmailResponse.observe(requireActivity()) {
//            when(it) {
//                is Resource.Success -> {
//                    Log.e("berhasiuyl", it.toString())
//                    Snackbar.make(bind.llTeacherFragment, "Email Telah Terkirim", Snackbar.LENGTH_SHORT).show()
//                }
//
//                is Resource.Failure -> {
//                    Log.e("guagal", it.toString())
//                    Snackbar.make(bind.llTeacherFragment, "Email Gagal Terkirim", Snackbar.LENGTH_SHORT).show()
//                }
//            }
//        }
        //

//        bind.rvTeacherCourse.layoutManager = teacherCourseLayoutManager
//        bind.rvTeacherCourse.clipChildren = false
//        teacherCourseAdapter = TeacherCourseAdapter(listTeacherCourse)
//        bind.rvTeacherCourse.adapter = teacherCourseAdapter
//        viewModelTeacherCourse.getListTeacherCourse("710001")
//        viewModelTeacherCourse.teacherCourseResponse.observe(requireActivity()) {
//            when(it) {
//                is Resource.Success -> {
//                    it.value.data?.let { it1 -> teacherCourseAdapter.setTeacherCourse(it1) }
//                    Snackbar.make(bind.llTeacherFragment, "rv muncul", Snackbar.LENGTH_LONG).show()
//                }
//                is Resource.Failure -> {
//                    Snackbar.make(bind.llTeacherFragment, "rv gagal", Snackbar.LENGTH_LONG).show()
//                }
//            }
//        }
//
//        return bind.root
//    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setInit()
        initView()
        initAction()
    }

    fun setInit() {
        val sendEmailRepo = SendEmailRepository(remoteDataSource.buildApi(SendEmailApi::class.java, CORE_BASE_URL))
        viewModelSendEmail = SendEmailViewModel(sendEmailRepo)

        val teacherCourseRepo = TeacherCourseRepository(remoteDataSource.buildApi(TeacherCourseApi::class.java, CORE_BASE_URL))
        viewModelTeacherCourse = TeacherCourseViewModel(teacherCourseRepo)
    }

    fun initView() {
        prefs.getNik.asLiveData().observe(requireActivity(), Observer{
            bind.tvUserNik.text = it
        })

        bind.rvTeacherCourse.layoutManager = teacherCourseLayoutManager
        bind.rvTeacherCourse.clipChildren = false
        bind.rvTeacherCourse.clipToPadding = false
        teacherCourseAdapterTesting = TeacherCourseAdapterTesting(requireActivity())
        bind.rvTeacherCourse.adapter = teacherCourseAdapterTesting
        viewModelTeacherCourse.getListTeacherCourse("710071")
//        viewModelTeacherCourse.getListTeacherCourse(runBlocking { prefs.getNik.first() })
        viewModelTeacherCourse.teacherCourseResponse.observe(requireActivity()) {
            when(it) {
                is Resource.Success -> {
                    teacherCourseAdapterTesting.setTeacherCourses(it.value.data!!)
                    Log.e("rv BERHASIL", it.toString())
//                    it.value.data?.let { it1 -> teacherCourseAdapterTesting.setTeacherCourses(it1) }
                    Snackbar.make(bind.llTeacherFragment, "rv muncul", Snackbar.LENGTH_LONG).show()
                }
                is Resource.Failure -> {
                    Log.e("rv GAGAL", it.toString())
                    Snackbar.make(bind.llTeacherFragment, "rv gagal", Snackbar.LENGTH_LONG).show()
                }
            }
        }
    }

    fun initAction() {
        teacherCourseAdapterTesting.setOnSelectedListener(object : OnItemClickListener{
            override fun onItemClick(itemView: View, position: Int) {
// send email testing
//        teacherCourseAdapter.setTeacherCourse(temporaryTeacherCourse)
                var request = SendEmailRequest()
                request.courseId = "IN212"
                request.academicPeriodId = "28104643-57bb-466b-9a68-091f3322c450"
                request.departmentId = "46c0d3ec-0063-4f26-8f14-6be3bbe99f07"
                request.courseName = "Web Dasar"
                viewModelSendEmail.sendEmail(request)
                viewModelSendEmail.sendEmailResponse.observe(requireActivity()) {
                    when(it) {
                        is Resource.Success -> {
                            Log.e("berhasil", it.toString())
                            goToActivityClearAllStack(MainActivity::class.java, null)
                            Snackbar.make(bind.llTeacherFragment, "Email Telah Terkirim", Snackbar.LENGTH_SHORT).show()
                        }

                        is Resource.Failure -> {
                            Log.e("gagal", it.toString())
                            Snackbar.make(bind.llTeacherFragment, "Email Gagal Terkirim", Snackbar.LENGTH_SHORT).show()
                        }
                    }
                }
                //
            }

            override fun onItemLongClick(itemView: View, position: Int): Boolean {
                return true
            }

        })
    }

    override fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?) = FragmentTeacherBinding.inflate(inflater,container, false)
}