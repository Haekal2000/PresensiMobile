package com.example.aplikasipresensi.ui.home.views

import android.os.Bundle
import android.util.DisplayMetrics
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
import com.example.aplikasipresensi.listener.OnItemClickListener
import com.example.aplikasipresensi.model.course.CourseModel
import com.example.aplikasipresensi.network.Resource
import com.example.aplikasipresensi.repository.CourseRepository
import com.example.aplikasipresensi.ui.home.viewmodel.CourseViewModel
import com.example.aplikasipresensi.util.CORE_BASE_URL
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

class StudentFragment : BaseFragment<FragmentStudentBinding>() {
    private lateinit var courseAdapter: CourseAdapter
    lateinit var viewModelCourse: CourseViewModel
    val courseLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setInit()
        initView()
        initAction()
    }

    fun Int.dpToPx(displayMetrics: DisplayMetrics): Int = (this * displayMetrics.density).toInt()

    fun setInit() {
        val courseRepo = CourseRepository(remoteDataSource.buildApi(CourseApi::class.java, CORE_BASE_URL))
        viewModelCourse = CourseViewModel(courseRepo)
    }

    fun initView() {
        prefs.getNrpId.asLiveData().observe(requireActivity(), Observer {
            bind.tvUserNrp.text = it
            Log.e("nama", prefs.getNrpId.toString())
        })

        bind.rvCourse.layoutManager = courseLayoutManager
        courseAdapter = CourseAdapter(requireContext())
        bind.rvCourse.adapter = courseAdapter
        viewModelCourse.getListCourse("46c0d3ec-0063-4f26-8f14-6be3bbe99f07", "28104643-57bb-466b-9a68-091f3322c450")
        Log.e("LISSTTTT", viewModelCourse.getListCourse("46c0d3ec-0063-4f26-8f14-6be3bbe99f07", "28104643-57bb-466b-9a68-091f3322c450").toString())
        viewModelCourse.courseResponse.observe(requireActivity()) {
            when(it) {
                is Resource.Success -> {
                    it.value.data?.let { it1 ->  courseAdapter.setCourse(it1)}
//                    courseAdapter.setCourse(it.value.data!!)
                    Snackbar.make(bind.llStudentFragment, "rv muncul", Snackbar.LENGTH_LONG).show()
                }
                is Resource.Failure -> {
                    Log.e("rv GAGAL", it.toString())
                    Snackbar.make(bind.llStudentFragment, "rv gagal", Snackbar.LENGTH_LONG).show()

                }
            }
        }
    }

    fun initAction() {
        courseAdapter.setOnSelectedListener(object : OnItemClickListener{
            override fun onItemClick(itemView: View, position: Int) {
                var bundle = Bundle()
                bundle.putString("courses", courseAdapter.getCourse().get(position).name)
                goToActivity(AttendanceDetailActivity::class.java, bundle, false)
            }

            override fun onItemLongClick(itemView: View, position: Int): Boolean {
                return true
            }

        })
    }

    override fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?) = FragmentStudentBinding.inflate(inflater,container, false)
}