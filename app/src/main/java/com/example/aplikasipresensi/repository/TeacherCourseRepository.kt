package com.example.aplikasipresensi.repository

import com.example.aplikasipresensi.api.TeacherCourseApi
import com.example.aplikasipresensi.base.BaseRepository

class TeacherCourseRepository(
    val service: TeacherCourseApi
) : BaseRepository() {

    suspend fun getListTeacherCourse(nik: String) = handlingApiCall {
        service.getListTeacherCourse(nik)
    }
}