//package com.example.aplikasipresensi.api
//
//import com.example.aplikasipresensi.responses.StudentResponse
//import retrofit2.http.GET
//import retrofit2.http.Query
//
//interface StudentApi {
//    @GET("login/studentdata")
//    suspend fun getListStudent(
//        @Query("nrpId") nrpId: Int
//    ): StudentResponse
//}