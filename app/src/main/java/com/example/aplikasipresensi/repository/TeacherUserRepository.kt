package com.example.aplikasipresensi.repository

import com.example.aplikasipresensi.api.TeacherUserApi
import com.example.aplikasipresensi.base.BaseRepository
import com.example.aplikasipresensi.preferences.DataPreferences
import com.example.aplikasipresensi.requests.TeacherUserRequest

class TeacherUserRepository(
    private val service: TeacherUserApi,
    private val preference: DataPreferences
) : BaseRepository() {

    suspend fun teacherLogin(user: TeacherUserRequest) = handlingApiCall {
        service.teacherLogin(user)
    }

    suspend fun setToken(token: String) {
        preference.setToken(token)
    }
}