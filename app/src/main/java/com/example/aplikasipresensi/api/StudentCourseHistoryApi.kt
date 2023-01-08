package com.example.aplikasipresensi.api

import com.example.aplikasipresensi.responses.StudentCourseHistoryResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface StudentCourseHistoryApi {
    @GET("student-course-history")
    suspend fun getStudentCourseHistory(
        @Query("department_id") departmentId: String,
        @Query("student_id") studentId: String
    ): StudentCourseHistoryResponse
}