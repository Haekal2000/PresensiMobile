package com.example.aplikasipresensi.repository

import com.example.aplikasipresensi.api.SendEmailApi
import com.example.aplikasipresensi.base.BaseRepository
import com.example.aplikasipresensi.preferences.DataPreferences
import com.example.aplikasipresensi.requests.SendEmailRequest

class SendEmailRepository(
    private val service: SendEmailApi
) : BaseRepository() {

    suspend fun sendEmail(sendEmail: SendEmailRequest) = handlingApiCall {
        service.sendEmail(sendEmail)
    }
}