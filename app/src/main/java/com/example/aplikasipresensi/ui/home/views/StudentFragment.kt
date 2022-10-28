package com.example.aplikasipresensi.ui.home.views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aplikasipresensi.R
import com.example.aplikasipresensi.adapter.CourseAdapter
import com.example.aplikasipresensi.api.CourseApi
import com.example.aplikasipresensi.base.BaseFragment
import com.example.aplikasipresensi.databinding.FragmentStudentBinding
import com.example.aplikasipresensi.model.course.CourseModel
import com.example.aplikasipresensi.network.Resource
import com.example.aplikasipresensi.repository.CourseRepository
import com.example.aplikasipresensi.ui.home.viewmodel.CourseViewModel
import com.example.aplikasipresensi.util.CORE_BASE_URL
import com.google.android.material.snackbar.Snackbar

class StudentFragment : BaseFragment<FragmentStudentBinding>() {
    private lateinit var courseAdapter: CourseAdapter
    lateinit var viewModelCourse: CourseViewModel
    var departmentId = ""
    var academicPeriodId = ""

    val courseLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
    val temporaryCourse = mutableListOf<CourseModel>()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setInit()
        initView()
    }

    fun setInit() {
        val courseRepo = CourseRepository(remoteDataSource.buildApi(CourseApi::class.java, CORE_BASE_URL))
        viewModelCourse = CourseViewModel(courseRepo)
    }

    fun initView() {
        prefs.getNrpId.asLiveData().observe(requireActivity(), Observer {
            bind.tvUserName.text = it
            Log.e("nama", prefs.getNrpId.toString())
        })

        bind.rvCourse.layoutManager = courseLayoutManager
        courseAdapter = CourseAdapter(requireContext())
        bind.rvCourse.adapter = courseAdapter

        viewModelCourse.getListCourse("", "")
        viewModelCourse.courseResponse.observe(requireActivity()) {
            when(it) {
                is Resource.Success -> {
                    courseAdapter.setCourse(temporaryCourse)
                    bind.tvWelcomeUser.text = temporaryCourse[0].name
//                    courseAdapter.setCourse(it.value.data!!)
//                    it.value.data?.let { it1 -> courseAdapter.setCourse(it1) }
                    Snackbar.make(bind.llStudentFragment, "rv muncul", Snackbar.LENGTH_LONG).show()
                }
                is Resource.Failure -> {
                    Log.e("rv GAGAL", it.toString())
                    Snackbar.make(bind.llStudentFragment, "rv gagal", Snackbar.LENGTH_LONG).show()

                }
            }
        }
    }

    override fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?) = FragmentStudentBinding.inflate(inflater,container, false)
}