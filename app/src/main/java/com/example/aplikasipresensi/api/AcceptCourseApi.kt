package com.example.aplikasipresensi.api

import com.example.aplikasipresensi.base.BaseResponse
import com.example.aplikasipresensi.requests.AcceptCourseRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface AcceptCourseApi {
    @POST("accept-course")
    suspend fun acceptCourse(
        @Body acceptCourseRequest: AcceptCourseRequest
    ): BaseResponse
}