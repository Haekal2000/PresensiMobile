package com.example.aplikasipresensi.ui.auth.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aplikasipresensi.network.Resource
import com.example.aplikasipresensi.repository.StudentDataRepository
import com.example.aplikasipresensi.responses.StudentDataResponse
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class StudentDataViewModel(
    private val studentDataRepo: StudentDataRepository
) : ViewModel() {

    private val _studentDataResponse: MutableLiveData<Resource<StudentDataResponse>> = MutableLiveData()
    val studentDataResponse: LiveData<Resource<StudentDataResponse>>
        get() = _studentDataResponse

    fun getStudentData(nrpId: String)
            = viewModelScope.launch {
        delay(3000)
        _studentDataResponse.value = studentDataRepo.getStudentData(nrpId)
    }

    fun setToken(token: String) = viewModelScope.launch {
        studentDataRepo.setToken(token)
    }

    fun setNrpId(nrpId: String) = viewModelScope.launch {
        studentDataRepo.setNrpId(nrpId)
    }

    fun setName(name: String) = viewModelScope.launch {
        studentDataRepo.setName(name)
    }

    fun setDepartmentId(departmentId: String) = viewModelScope.launch {
        studentDataRepo.setDepartmentId(departmentId)
    }

    fun setAcademicPeriodId(academicPeriodId: String) = viewModelScope.launch {
        studentDataRepo.setAcademicPeriodId(academicPeriodId)
    }
}