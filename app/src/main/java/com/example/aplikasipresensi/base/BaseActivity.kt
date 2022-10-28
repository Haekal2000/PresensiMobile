package com.example.aplikasipresensi.base

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.example.aplikasipresensi.R
import com.example.aplikasipresensi.network.RemoteDataSource
import com.example.aplikasipresensi.preferences.DataPreferences

abstract class BaseActivity<vb: ViewBinding>: AppCompatActivity() {

    protected lateinit var bind: vb
    protected lateinit var viewModel: ViewModel
    protected val remotedDataSource = RemoteDataSource(this)
    protected lateinit var prefs: DataPreferences
    var dataReceived: Bundle? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        prefs = DataPreferences(this)
        dataReceived = intent.extras
        if (intent != null) {
            dataReceived = intent.extras
        }
        bind = getActivityBinding(layoutInflater)
        val factory = ViewModelFactory(applicationContext)
        setContentView(bind.root)
    }

    override fun onBackPressed() {
        super.onBackPressed()

        backToPreviousPage()
    }

    abstract fun getActivityBinding(layoutInflater: LayoutInflater): vb

    fun goToActivity(c: Class<*>, bundle: Bundle?, isFinish: Boolean) {
        val i = Intent(this, c)
        if (bundle != null) {
            i.putExtras(bundle)
        }
        startActivity(i)
        overridePendingTransition(R.anim.to_left, R.anim.to_stay)
        if (isFinish) {
            finish()
        }
    }

    fun goToActivityNoTransition(c:Class<*>, bundle: Bundle?, isFinish: Boolean) {
        val i = Intent(this, c)
        if (bundle != null) {
            i.putExtras(bundle)
        }
        startActivity(i)
        if (isFinish) {
            finish()
        }
    }

    fun goToActivityClearAllStack(c: Class<*>, bundle: Bundle?) {
        val i = Intent(this, c)
        if (bundle != null) {
            i.putExtras(bundle)
        }
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        startActivity(i)
        finish()
        overridePendingTransition(R.anim.to_left, R.anim.to_stay)
    }

    fun goToActivityBackPageClearAllStack(c: Class<*>, bundle: Bundle?) {
        val i = Intent(this, c)
        if (bundle != null) {
            i.putExtras(bundle)
        }
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        startActivity(i)
        overridePendingTransition(R.anim.to_stay, R.anim.to_right)
        finish()
    }

    fun backToPreviousPage() {
        finish()
        overridePendingTransition(R.anim.to_stay, R.anim.to_right)
    }
}