package com.example.aplikasipresensi.repository

import android.util.Log
import com.example.aplikasipresensi.api.CourseApi
import com.example.aplikasipresensi.base.BaseRepository

class CourseRepository(
   val service: CourseApi
) : BaseRepository() {

    suspend fun getListCourse(departmentId: String, academicPeriodId: String, studentId: String) = handlingApiCall {
        service.getListCourse(departmentId, academicPeriodId, studentId)
    }
}