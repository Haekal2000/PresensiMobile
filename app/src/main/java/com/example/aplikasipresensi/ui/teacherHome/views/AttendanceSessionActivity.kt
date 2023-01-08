package com.example.aplikasipresensi.ui.teacherHome.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.aplikasipresensi.api.ClosingCourseApi
import com.example.aplikasipresensi.base.BaseActivity
import com.example.aplikasipresensi.databinding.ActivityAttendanceDetailBinding
import com.example.aplikasipresensi.databinding.ActivityAttendanceSessionBinding
import com.example.aplikasipresensi.repository.ClosingCourseRepository
import com.example.aplikasipresensi.requests.ClosingCourseRequest
import com.example.aplikasipresensi.ui.teacherHome.viewmodel.ClosingCourseViewModel
import com.example.aplikasipresensi.util.CORE_BASE_URL
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

class AttendanceSessionActivity : BaseActivity<ActivityAttendanceSessionBinding>() {
    lateinit var viewModelClosingCourse: ClosingCourseViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setInit()
        initAction()
    }

    fun setInit() {
        val closingCourseRepo = ClosingCourseRepository(remotedDataSource.buildApi(ClosingCourseApi::class.java, CORE_BASE_URL))
        viewModelClosingCourse = ClosingCourseViewModel(closingCourseRepo)
    }

    fun initAction() {
        bind.swCloseCourse.setOnClickListener {
            var request = ClosingCourseRequest()
            request.lecturerNik = runBlocking { prefs.getNik.first() }
            request.courseId = "IN212"
            request.scheduleId = "YIzVZ"
            request.isComplete = true
            viewModelClosingCourse.closingCourse(request)
        }
    }

    override fun getActivityBinding(layoutInflater: LayoutInflater) = ActivityAttendanceSessionBinding.inflate(layoutInflater)

}