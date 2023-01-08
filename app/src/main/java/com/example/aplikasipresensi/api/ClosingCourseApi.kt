package com.example.aplikasipresensi.api

import com.example.aplikasipresensi.base.BaseResponse
import com.example.aplikasipresensi.requests.ClosingCourseRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface ClosingCourseApi {
    @POST("closing-course")
    suspend fun closingCourse(
        @Body closingCourseRequest: ClosingCourseRequest
    ): BaseResponse
}