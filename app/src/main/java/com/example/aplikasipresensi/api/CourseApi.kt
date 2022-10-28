package com.example.aplikasipresensi.api

import com.example.aplikasipresensi.responses.CourseResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CourseApi {
    @GET("course")
    suspend fun getListCourse(
        @Query("department_id") departmentId: String,
        @Query("academic_period_id") academicPeriodId: String
    ) : CourseResponse
}