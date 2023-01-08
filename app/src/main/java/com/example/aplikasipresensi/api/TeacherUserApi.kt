package com.example.aplikasipresensi.api

import com.example.aplikasipresensi.requests.TeacherUserRequest
import com.example.aplikasipresensi.responses.TeacherUserResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface TeacherUserApi {
    @POST("login-lecture")
    suspend fun teacherLogin(
        @Body teacherUserRequest: TeacherUserRequest
    ): TeacherUserResponse
}