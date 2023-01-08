package com.example.aplikasipresensi.ui.home.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aplikasipresensi.adapter.StudentCourseHistoryAdapter
import com.example.aplikasipresensi.api.StudentCourseHistoryApi
import com.example.aplikasipresensi.base.BaseActivity
import com.example.aplikasipresensi.databinding.ActivityAttendanceDetailBinding
import com.example.aplikasipresensi.databinding.ActivityHomeBinding
import com.example.aplikasipresensi.network.Resource
import com.example.aplikasipresensi.repository.StudentCourseHistoryRepository
import com.example.aplikasipresensi.ui.home.viewmodel.StudentCourseHistoryViewModel
import com.example.aplikasipresensi.util.CORE_BASE_URL
import com.google.android.material.snackbar.Snackbar

class AttendanceDetailActivity : BaseActivity<ActivityAttendanceDetailBinding>() {
    private lateinit var studentCourseHistoryAdapter: StudentCourseHistoryAdapter
    lateinit var viewModelStudentCourseHistory: StudentCourseHistoryViewModel
    var studentCourseHistoryLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setInit()
        initView()
        initAction()
    }

    fun setInit() {
        val studentCourseHistoryRepo = StudentCourseHistoryRepository(remotedDataSource.buildApi(StudentCourseHistoryApi::class.java, CORE_BASE_URL))
        viewModelStudentCourseHistory = StudentCourseHistoryViewModel(studentCourseHistoryRepo)
    }

    fun initView() {
        bind.rvAttendanceDetail.layoutManager = studentCourseHistoryLayoutManager
        bind.rvAttendanceDetail.clipChildren = false
        studentCourseHistoryAdapter = StudentCourseHistoryAdapter(this)
        bind.rvAttendanceDetail.adapter = studentCourseHistoryAdapter

        viewModelStudentCourseHistory.getListStudentCourseHistory("46c0d3ec-0063-4f26-8f14-6be3bbe99f07", "1973010")
        viewModelStudentCourseHistory.studentCourseHistoryResponse.observe(this) {
            when(it) {
                is Resource.Success -> {
                    it.value.data?.let { it1 -> studentCourseHistoryAdapter.setStudentCourseHistory(it1) }
                }
                is Resource.Failure -> {
                    Snackbar.make(bind.llAttendanceDetail, "rv gagal", Snackbar.LENGTH_LONG).show()
                }
            }
        }
    }

    fun initAction() {
        bind.ivBack.setOnClickListener { finish() }
    }

    override fun getActivityBinding(layoutInflater: LayoutInflater) = ActivityAttendanceDetailBinding.inflate(layoutInflater)
}