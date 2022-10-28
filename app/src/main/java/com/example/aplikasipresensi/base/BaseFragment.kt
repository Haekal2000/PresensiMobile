package com.example.aplikasipresensi.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.aplikasipresensi.network.RemoteDataSource
import com.example.aplikasipresensi.preferences.DataPreferences

abstract class BaseFragment<vb: ViewBinding>: Fragment() {

    protected lateinit var bind: vb
    protected lateinit var remoteDataSource : RemoteDataSource
    protected lateinit var prefs: DataPreferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        remoteDataSource = RemoteDataSource(this.activity!!)
        prefs = DataPreferences(this.activity!!)
        bind = getFragmentBinding(inflater, container)
        return bind.root
    }

    abstract fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?): vb

    fun goToActivity(c: Class<*>, bundle: Bundle?, isFinish: Boolean) {
        (activity as BaseActivity<vb>).goToActivity(c, bundle, isFinish)
    }

    fun goToActivityNoTransition(c: Class<*>, bundle: Bundle?, isFinish: Boolean) {
        (activity as BaseActivity<vb>).goToActivityNoTransition(c, bundle, isFinish)
    }

    fun goToActivityClearAllStack(c:Class<*>, bundle: Bundle?) {
        (activity as BaseActivity<vb>).goToActivityClearAllStack(c, bundle)
    }

    fun goToActivityBackPageClearAllStack(c: Class<*>, bundle: Bundle?) {
        (activity as BaseActivity<vb>).goToActivityBackPageClearAllStack(c, bundle)
    }
}