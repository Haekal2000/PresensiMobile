package com.example.aplikasipresensi.ui.teacherProfile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aplikasipresensi.R
import com.example.aplikasipresensi.base.BaseFragment
import com.example.aplikasipresensi.databinding.FragmentTeacherBinding
import com.example.aplikasipresensi.databinding.FragmentTeacherProfileBinding
import com.example.aplikasipresensi.ui.teacherHome.views.TeacherFragment

class TeacherProfileFragment : BaseFragment<FragmentTeacherProfileBinding>() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?) = FragmentTeacherProfileBinding.inflate(inflater,container, false)
}