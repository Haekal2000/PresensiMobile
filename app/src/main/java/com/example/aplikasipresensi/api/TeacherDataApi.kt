package com.example.aplikasipresensi.api

import com.example.aplikasipresensi.responses.TeacherDataResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TeacherDataApi {
    @GET("lecture-data")
    suspend fun getTeacherData(
        @Query("nik") nik: String
    ) : TeacherDataResponse
}