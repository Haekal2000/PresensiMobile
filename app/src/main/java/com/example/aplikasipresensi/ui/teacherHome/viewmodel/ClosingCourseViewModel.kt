package com.example.aplikasipresensi.ui.teacherHome.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aplikasipresensi.base.BaseResponse
import com.example.aplikasipresensi.network.Resource
import com.example.aplikasipresensi.repository.ClosingCourseRepository
import com.example.aplikasipresensi.requests.ClosingCourseRequest
import kotlinx.coroutines.launch

class ClosingCourseViewModel(
    private val closingCourseRepo: ClosingCourseRepository
) : ViewModel() {

    private val _closingCourseResponse: MutableLiveData<Resource<BaseResponse>> = MutableLiveData()
    val closingCourseResponse: LiveData<Resource<BaseResponse>>
        get() = _closingCourseResponse

    fun closingCourse(closingCourse: ClosingCourseRequest)
            = viewModelScope.launch {
        _closingCourseResponse.value = closingCourseRepo.closingCourse(closingCourse)
    }
}