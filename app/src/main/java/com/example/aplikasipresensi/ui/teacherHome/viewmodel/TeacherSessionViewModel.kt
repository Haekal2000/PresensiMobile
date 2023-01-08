package com.example.aplikasipresensi.ui.teacherHome.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aplikasipresensi.network.Resource
import com.example.aplikasipresensi.repository.TeacherSessionRepository
import com.example.aplikasipresensi.responses.TeacherSessionResponse
import kotlinx.coroutines.launch

class TeacherSessionViewModel(
    private val teacherSessionRepo: TeacherSessionRepository
) : ViewModel() {

    private val _teacherSessionResponse: MutableLiveData<Resource<TeacherSessionResponse>> = MutableLiveData()
    val teacherSessionResponse: LiveData<Resource<TeacherSessionResponse>>
        get() = _teacherSessionResponse

    fun getListTeacherSession(nik: String)
            = viewModelScope.launch {
        _teacherSessionResponse.value = teacherSessionRepo.getListTeacherSession(nik)
    }
}