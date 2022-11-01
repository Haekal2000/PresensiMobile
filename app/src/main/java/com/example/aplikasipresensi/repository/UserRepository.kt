package com.example.aplikasipresensi.repository

import com.example.aplikasipresensi.api.UserApi
import com.example.aplikasipresensi.base.BaseRepository
import com.example.aplikasipresensi.preferences.DataPreferences
import com.example.aplikasipresensi.requests.UserRequest

class UserRepository(
    private val service: UserApi,
    private val preference: DataPreferences
) : BaseRepository() {

    suspend fun login(user: UserRequest) = handlingApiCall {
        service.login(user)
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