package com.example.aplikasipresensi.ui.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aplikasipresensi.network.Resource
import com.example.aplikasipresensi.repository.StudentCourseHistoryRepository
import com.example.aplikasipresensi.responses.StudentCourseHistoryResponse
import kotlinx.coroutines.launch

class StudentCourseHistoryViewModel(
    private val studentCourseHistoryRepo: StudentCourseHistoryRepository
) : ViewModel() {

    private val _studentCourseHistoryResponse: MutableLiveData<Resource<StudentCourseHistoryResponse>> = MutableLiveData()
    val studentCourseHistoryResponse: LiveData<Resource<StudentCourseHistoryResponse>>
        get() = _studentCourseHistoryResponse

    fun getListStudentCourseHistory(departmentId: String, studentId: String)
            = viewModelScope.launch {
                _studentCourseHistoryResponse.value = studentCourseHistoryRepo.getListStudentCourseHistory(departmentId, studentId)
    }
}