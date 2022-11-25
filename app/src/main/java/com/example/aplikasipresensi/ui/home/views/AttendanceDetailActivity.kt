package com.example.aplikasipresensi.ui.home.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.aplikasipresensi.base.BaseActivity
import com.example.aplikasipresensi.databinding.ActivityAttendanceDetailBinding
import com.example.aplikasipresensi.databinding.ActivityHomeBinding

class AttendanceDetailActivity : BaseActivity<ActivityAttendanceDetailBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initAction()
    }

    fun initAction() {
        bind.ivBack.setOnClickListener { finish() }
    }

    override fun getActivityBinding(layoutInflater: LayoutInflater) = ActivityAttendanceDetailBinding.inflate(layoutInflater)
}