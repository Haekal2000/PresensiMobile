package com.example.aplikasipresensi.repository

import com.example.aplikasipresensi.api.TeacherDataApi
import com.example.aplikasipresensi.base.BaseRepository
import com.example.aplikasipresensi.preferences.DataPreferences

class TeacherDataRepository(
    private val service: TeacherDataApi,
    private val preference: DataPreferences
) : BaseRepository() {

    suspend fun getTeacherData(nik: String) = handlingApiCall {
        service.getTeacherData(nik)
    }

    suspend fun setName(name: String) {
        preference.setName(name)
    }

    suspend fun setNik(nik: String) {
        preference.setNik(nik)
    }

    suspend fun setDepartmentId(departmentId: String) {
        preference.setDepartmentId(departmentId)
    }
}