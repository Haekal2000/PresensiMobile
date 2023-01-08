package com.example.aplikasipresensi.repository

import com.example.aplikasipresensi.api.StudentDataApi
import com.example.aplikasipresensi.base.BaseRepository
import com.example.aplikasipresensi.preferences.DataPreferences

class StudentDataRepository(
    private val service: StudentDataApi,
    private val preference: DataPreferences
) : BaseRepository() {

    suspend fun getStudentData(nrpId: String) = handlingApiCall {
        service.getStudentData(nrpId)
    }

    suspend fun setToken(token: String) {
        preference.setToken(token)
    }

    suspend fun setNrpId(nrpId: String) {
        preference.setNrpId(nrpId)
    }

    suspend fun setName(name: String) {
        preference.setName(name)
    }

    suspend fun setDepartmentId(departmentId: String) {
        preference.setDepartmentId(departmentId)
    }

    suspend fun setAcademicPeriodId(academicPeriodId: String) {
        preference.setAcademicPeriodId(academicPeriodId)
    }
}