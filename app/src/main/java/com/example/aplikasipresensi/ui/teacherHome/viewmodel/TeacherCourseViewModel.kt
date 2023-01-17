package com.example.aplikasipresensi.ui.teacherHome.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aplikasipresensi.network.Resource
import com.example.aplikasipresensi.repository.TeacherCourseRepository
import com.example.aplikasipresensi.responses.TeacherCourseResponse
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class TeacherCourseViewModel(
    private val teacherCourseRepo: TeacherCourseRepository
) : ViewModel() {

    private val _teacherCourseResponse: MutableLiveData<Resource<TeacherCourseResponse>> = MutableLiveData()
    val teacherCourseResponse: LiveData<Resource<TeacherCourseResponse>>
        get() = _teacherCourseResponse

    fun getListTeacherCourse(nik: String)
            = viewModelScope.launch {
        delay(300)
        _teacherCourseResponse.value = teacherCourseRepo.getListTeacherCourse(nik)
    }
}