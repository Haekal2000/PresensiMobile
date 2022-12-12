package com.example.aplikasipresensi.ui.home.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aplikasipresensi.R
import com.example.aplikasipresensi.databinding.FragmentTestBinding

class TestFragment private constructor(): Fragment() {

    private lateinit var names: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        names = ArrayList()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentTestBinding = FragmentTestBinding.inflate(inflater, container, false)
        return fragmentTestBinding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = TestFragment()
    }
}