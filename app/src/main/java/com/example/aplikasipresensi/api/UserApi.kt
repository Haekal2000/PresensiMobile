package com.example.aplikasipresensi.api

import com.example.aplikasipresensi.requests.UserRequest
import com.example.aplikasipresensi.responses.UserResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {
    @POST("login-student")
    suspend fun login(
        @Body userRequest: UserRequest
    ): UserResponse
}