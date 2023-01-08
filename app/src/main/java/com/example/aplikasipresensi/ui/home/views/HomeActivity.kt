package com.example.aplikasipresensi.ui.home.views

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import androidx.lifecycle.asLiveData
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
import com.google.android.material.navigation.NavigationBarView
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

class HomeActivity : BaseActivity<ActivityHomeBinding>() {
    lateinit var viewModelUser: UserViewModel
    lateinit var selectedFragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setInit()
        initView()
        initAciton()
    }

    fun setInit() {
        val userRepo = UserRepository(remotedDataSource.buildApi(UserApi::class.java, CORE_BASE_URL), DataPreferences(applicationContext))
        viewModelUser = UserViewModel(userRepo)
    }

    fun initView() {
        selectedFragment = StudentFragment()
        bind.bottomNavigation.setOnItemSelectedListener(mOnNavigationItemSelectedListener)
        bind.bottomNavigation.itemIconTintList = null
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.cl_navigation, selectedFragment)
        transaction.commit()
    }

    private val mOnNavigationItemSelectedListener = NavigationBarView.OnItemSelectedListener { item ->
        when (item.itemId) {
            R.id.nav_home -> {
                selectedFragment = StudentFragment()
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

    fun initAciton() {
        bind.btnScanner.setOnClickListener {
            val intent = Intent(this, CodeScannerActivity::class.java)
            startActivity(intent)
        }
    }

    override fun getActivityBinding(layoutInflater: LayoutInflater) = ActivityHomeBinding.inflate(layoutInflater)

}