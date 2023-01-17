package com.example.aplikasipresensi.ui.teacherAuth.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aplikasipresensi.network.Resource
import com.example.aplikasipresensi.repository.TeacherDataRepository
import com.example.aplikasipresensi.responses.TeacherDataResponse
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class TeacherDataViewModel(
    private val teacherDataRepo: TeacherDataRepository
) : ViewModel() {

    private val _teacherDataResponse: MutableLiveData<Resource<TeacherDataResponse>> = MutableLiveData()
    val teacherDataResponse: LiveData<Resource<TeacherDataResponse>>
        get() = _teacherDataResponse

    fun getTeacherData(nik: String)
            = viewModelScope.launch {
        delay(100)
        _teacherDataResponse.value = teacherDataRepo.getTeacherData(nik)
    }

    fun setName(name: String) = viewModelScope.launch {
        teacherDataRepo.setName(name)
    }

    fun setNik(nik: String) = viewModelScope.launch {
        teacherDataRepo.setNik(nik)
    }

    fun setDepartmentId(departmentId: String) = viewModelScope.launch {
        teacherDataRepo.setDepartmentId(departmentId)
    }
}