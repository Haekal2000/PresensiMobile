//package com.example.aplikasipresensi.repository
//
//import android.util.Log
//import com.example.aplikasipresensi.api.StudentApi
//import com.example.aplikasipresensi.base.BaseRepository
//import com.example.aplikasipresensi.preferences.DataPreferences
//
//class StudentRepository(
//    private val service: StudentApi,
//    private val preference: DataPreferences
//) : BaseRepository() {
//
//    suspend fun getListStudent(nrpId: Int) = handlingApiCall {
//        service.getListStudent(nrpId)
//    }
//
//    suspend fun setName(name: String) {
//        preference.setName(name)
//    }
//
//    suspend fun setImage(image: String) {
//        preference.setImage(image)
//    }
//
//    suspend fun setDepartmentId(departmentId: String) {
//        preference.setDepartmentId(departmentId)
//    }
//
//    suspend fun setDepartmentName(departmentName: String) {
//        preference.setDepartmentName(departmentName)
//    }
//
//    suspend fun setNrpId(nrpId: String) {
//        preference.setNrpId(nrpId)
//    }
//}