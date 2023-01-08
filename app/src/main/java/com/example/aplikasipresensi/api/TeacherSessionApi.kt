package com.example.aplikasipresensi.api

import com.example.aplikasipresensi.responses.TeacherSessionResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TeacherSessionApi {
    @GET("lecturer-session")
    suspend fun getListLecturerSession(
        @Query("lecturer_nik") nik: String
    ) : TeacherSessionResponse
}