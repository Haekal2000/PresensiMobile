package com.example.aplikasipresensi.api

import com.example.aplikasipresensi.responses.TeacherCourseHistoryResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TeacherCourseHistoryApi {
    @GET("course-history")
    suspend fun getTeacherCourseHistory(
        @Query("lecturer_nik") lecturerNik: String,
        @Query("course_id") courseId: String,
        @Query("department_id") departmentId: String
    ) : TeacherCourseHistoryResponse
}