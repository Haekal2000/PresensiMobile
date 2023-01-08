package com.example.aplikasipresensi.ui.teacherHome.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.aplikasipresensi.base.BaseActivity
import com.example.aplikasipresensi.databinding.ActivityAttendanceSessionBinding
import com.example.aplikasipresensi.databinding.ActivityStudentAttendanceBinding

class StudentAttendanceActivity : BaseActivity<ActivityStudentAttendanceBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun getActivityBinding(layoutInflater: LayoutInflater) = ActivityStudentAttendanceBinding.inflate(layoutInflater)

}