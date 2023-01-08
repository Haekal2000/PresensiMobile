package com.example.aplikasipresensi.api

import com.example.aplikasipresensi.responses.TeacherCourseResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TeacherCourseApi {
    @GET("lecturer-schedule")
    suspend fun getListTeacherCourse(
        @Query("lecturer_nik") nik: String
    ) : TeacherCourseResponse
}