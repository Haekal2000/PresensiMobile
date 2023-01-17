package com.example.aplikasipresensi.ui.home.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aplikasipresensi.network.Resource
import com.example.aplikasipresensi.repository.CourseRepository
import com.example.aplikasipresensi.responses.CourseResponse
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CourseViewModel(
    private val courseRepo: CourseRepository
) : ViewModel() {

    private val _courseResponse: MutableLiveData<Resource<CourseResponse>> = MutableLiveData()
    val courseResponse: LiveData<Resource<CourseResponse>>
        get() = _courseResponse

    fun getListCourse(departmentId: String, academicPeriodId: String, studentId: String)
            = viewModelScope.launch {
        delay(250)
        _courseResponse.value = courseRepo.getListCourse(departmentId, academicPeriodId, studentId)
    }
}