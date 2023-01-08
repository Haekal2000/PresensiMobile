package com.example.aplikasipresensi.repository

import com.example.aplikasipresensi.api.TeacherCourseHistoryApi
import com.example.aplikasipresensi.base.BaseRepository

class TeacherCourseHistoryRepository(
    val service: TeacherCourseHistoryApi
) : BaseRepository() {

    suspend fun getListTeacherCourseHistory(lecturerNik: String, courseId: String, departmentId: String) = handlingApiCall {
        service.getTeacherCourseHistory(lecturerNik, courseId, departmentId)
    }
}