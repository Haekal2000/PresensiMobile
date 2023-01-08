package com.example.aplikasipresensi.repository

import com.example.aplikasipresensi.api.StudentCourseHistoryApi
import com.example.aplikasipresensi.base.BaseRepository

class StudentCourseHistoryRepository(
    val service: StudentCourseHistoryApi
) : BaseRepository() {

    suspend fun getListStudentCourseHistory(departmentId: String, studentId: String) = handlingApiCall {
        service.getStudentCourseHistory(departmentId, studentId)
    }
}