package com.example.aplikasipresensi.ui.home.views

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import com.example.aplikasipresensi.R
import com.example.aplikasipresensi.api.UserApi
import com.example.aplikasipresensi.base.BaseActivity
import com.example.aplikasipresensi.databinding.ActivityHomeBinding
import com.example.aplikasipresensi.preferences.DataPreferences
import com.example.aplikasipresensi.repository.UserRepository
import com.example.aplikasipresensi.ui.profile.ProfileFragment
import com.example.aplikasipresensi.util.CORE_BASE_URL
import com.example.aplikasipresensi.ui.auth.viewmodel.UserViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : BaseActivity<ActivityHomeBinding>() {
    lateinit var viewModelUser: UserViewModel
    var selectedFragment: Fragment = StudentFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setInit()
        initView()
    }

    fun setInit() {
        val userRepo = UserRepository(remotedDataSource.buildApi(UserApi::class.java, CORE_BASE_URL), DataPreferences(applicationContext))
        viewModelUser = UserViewModel(userRepo)
    }

    fun initView() {
        bind.bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        bind.bottomNavigation.itemIconTintList = null
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.cl_navigation, StudentFragment())
        transaction.commit()
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.nav_home -> {
                selectedFragment = StudentFragment.
//                selectedFragment = TestFragment.newInstance()
            }

            R.id.nav_profile -> {
                selectedFragment = ProfileFragment()
            }
        }

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.cl_navigation, selectedFragment)
        transaction.commit()
        true
    }

    override fun getActivityBinding(layoutInflater: LayoutInflater) = ActivityHomeBinding.inflate(layoutInflater)

}