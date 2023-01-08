package com.example.aplikasipresensi.ui.teacherHome.views

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import com.example.aplikasipresensi.R
import com.example.aplikasipresensi.base.BaseActivity
import com.example.aplikasipresensi.databinding.ActivityTeacherHomeBinding
import com.example.aplikasipresensi.ui.teacherProfile.TeacherProfileFragment
import com.google.android.material.navigation.NavigationBarView

class TeacherHomeActivity : BaseActivity<ActivityTeacherHomeBinding>() {
    lateinit var selectedFragment: Fragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setInit()
        initView()
    }

    fun setInit() {

    }

    fun initView() {
//        selectedFragment = TeacherFragment.newInstance()
        selectedFragment = TeacherFragment()
        bind.teacherBottomNavigation.setOnItemSelectedListener(mOnNavigationItemSelectedListener)
        bind.teacherBottomNavigation.itemIconTintList = null
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.teacher_fragment_container, selectedFragment)
        transaction.commit()
    }

    private val mOnNavigationItemSelectedListener = NavigationBarView.OnItemSelectedListener { item ->
        when (item.itemId) {
            R.id.teacher_nav_home -> {
                selectedFragment = TeacherFragment()
            }

            R.id.teacher_nav_profile -> {
                selectedFragment = TeacherProfileFragment()
            }
        }

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.teacher_fragment_container, selectedFragment)
        transaction.commit()
        true
    }

    override fun getActivityBinding(layoutInflater: LayoutInflater) = ActivityTeacherHomeBinding.inflate(layoutInflater)

}