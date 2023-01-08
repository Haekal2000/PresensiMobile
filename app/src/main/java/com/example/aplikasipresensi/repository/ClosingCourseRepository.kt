package com.example.aplikasipresensi.repository

import com.example.aplikasipresensi.api.ClosingCourseApi
import com.example.aplikasipresensi.base.BaseRepository
import com.example.aplikasipresensi.requests.ClosingCourseRequest

class ClosingCourseRepository(
    private val service: ClosingCourseApi
) : BaseRepository() {

    suspend fun closingCourse(closingCourse: ClosingCourseRequest) = handlingApiCall {
        service.closingCourse(closingCourse)
    }
}