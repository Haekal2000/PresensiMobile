package com.example.aplikasipresensi.repository

import com.example.aplikasipresensi.api.TeacherSessionApi
import com.example.aplikasipresensi.base.BaseRepository

class TeacherSessionRepository(
    val service: TeacherSessionApi
) : BaseRepository() {

    suspend fun getListTeacherSession(nik: String) = handlingApiCall {
        service.getListLecturerSession(nik)
    }
}