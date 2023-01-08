package com.example.aplikasipresensi.api

import com.example.aplikasipresensi.responses.StudentDataResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface StudentDataApi {
    @GET("student-data")
    suspend fun getStudentData(
        @Query("nrpId") nrpId: String
    ) : StudentDataResponse
}