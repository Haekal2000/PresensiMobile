package com.example.aplikasipresensi.api

import com.example.aplikasipresensi.base.BaseResponse
import com.example.aplikasipresensi.requests.SendEmailRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface SendEmailApi {
    @POST("send-email")
    suspend fun sendEmail(
        @Body sendEmailRequest: SendEmailRequest
    ): BaseResponse
}