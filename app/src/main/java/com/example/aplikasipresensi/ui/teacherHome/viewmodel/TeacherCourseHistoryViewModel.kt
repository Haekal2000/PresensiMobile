package com.example.aplikasipresensi.ui.teacherHome.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aplikasipresensi.network.Resource
import com.example.aplikasipresensi.repository.TeacherCourseHistoryRepository
import com.example.aplikasipresensi.responses.TeacherCourseHistoryResponse
import kotlinx.coroutines.launch

class TeacherCourseHistoryViewModel(
    private val teacherCourseHistoryRepo: TeacherCourseHistoryRepository
) : ViewModel() {

    private val _teacherCourseHistoryResponse: MutableLiveData<Resource<TeacherCourseHistoryResponse>> = MutableLiveData()
    val teacherCourseHistoryResponse: LiveData<Resource<TeacherCourseHistoryResponse>>
        get() = _teacherCourseHistoryResponse

    fun getListTeacherCourseHistory(lecturerNik: String, courseId: String, departmentId: String)
            = viewModelScope.launch {
                _teacherCourseHistoryResponse.value = teacherCourseHistoryRepo.getListTeacherCourseHistory(lecturerNik, courseId, departmentId)
    }
}