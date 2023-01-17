package com.example.aplikasipresensi.model.teacher

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TeacherCourseNameModel {
    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("department_id")
    @Expose
    var departmentId: String? = null
}