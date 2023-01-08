package com.example.aplikasipresensi.repository

import com.example.aplikasipresensi.api.AcceptCourseApi
import com.example.aplikasipresensi.base.BaseRepository
import com.example.aplikasipresensi.requests.AcceptCourseRequest

class AcceptCourseRepository(
    private val service: AcceptCourseApi
) : BaseRepository() {

    suspend fun acceptCourse(acceptCourse: AcceptCourseRequest) = handlingApiCall {
        service.acceptCourse(acceptCourse)
    }
}