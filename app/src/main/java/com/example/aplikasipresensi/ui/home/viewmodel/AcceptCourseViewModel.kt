package com.example.aplikasipresensi.ui.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aplikasipresensi.base.BaseResponse
import com.example.aplikasipresensi.network.Resource
import com.example.aplikasipresensi.repository.AcceptCourseRepository
import com.example.aplikasipresensi.requests.AcceptCourseRequest
import kotlinx.coroutines.launch

class AcceptCourseViewModel(
    private val acceptCourseRepo: AcceptCourseRepository
) : ViewModel() {

    private val _acceptCourseResponse: MutableLiveData<Resource<BaseResponse>> = MutableLiveData()
    val acceptCourseResponse: LiveData<Resource<BaseResponse>>
        get() = _acceptCourseResponse

    fun acceptCourse(acceptCourse: AcceptCourseRequest)
            = viewModelScope.launch {
                _acceptCourseResponse.value = acceptCourseRepo.acceptCourse(acceptCourse)
    }
}