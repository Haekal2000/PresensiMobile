package com.example.aplikasipresensi.ui.teacherHome.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aplikasipresensi.adapter.TeacherSessionAdapter
import com.example.aplikasipresensi.api.TeacherSessionApi
import com.example.aplikasipresensi.base.BaseActivity
import com.example.aplikasipresensi.databinding.ActivityAttendanceDetailBinding
import com.example.aplikasipresensi.databinding.ActivityTeacherSessionListBinding
import com.example.aplikasipresensi.network.Resource
import com.example.aplikasipresensi.repository.TeacherSessionRepository
import com.example.aplikasipresensi.ui.teacherHome.viewmodel.TeacherSessionViewModel
import com.example.aplikasipresensi.util.CORE_BASE_URL
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

class TeacherSessionListActivity : BaseActivity<ActivityTeacherSessionListBinding>() {
    private lateinit var teacherSessionAdapter: TeacherSessionAdapter
    lateinit var viewModelTeacherSession: TeacherSessionViewModel
    val teacherSessionLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setInit()
        initView()
    }

    fun setInit() {
        val teacherSessionRepo = TeacherSessionRepository(remotedDataSource.buildApi(TeacherSessionApi::class.java, CORE_BASE_URL))
        viewModelTeacherSession = TeacherSessionViewModel(teacherSessionRepo)
    }

    fun initView() {
        bind.rvTeacherSession.layoutManager = teacherSessionLayoutManager
        bind.rvTeacherSession.clipChildren = false
        teacherSessionAdapter = TeacherSessionAdapter(this)
        bind.rvTeacherSession.adapter = teacherSessionAdapter

        viewModelTeacherSession.getListTeacherSession(runBlocking { prefs.getNik.first() })
        viewModelTeacherSession.teacherSessionResponse.observe(this) {
            when(it) {
                is Resource.Success -> {
                    teacherSessionAdapter.setTeacherSession(it.value.data!!)
                }
                is Resource.Failure -> {
                    Snackbar.make(bind.llTeacherSession, "rv gagal", Snackbar.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun getActivityBinding(layoutInflater: LayoutInflater) = ActivityTeacherSessionListBinding.inflate(layoutInflater)

}