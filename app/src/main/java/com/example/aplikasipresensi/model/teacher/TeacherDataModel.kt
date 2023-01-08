package com.example.aplikasipresensi.model.teacher

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TeacherDataModel {
    @SerializedName("nik")
    @Expose
    var nik: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("email")
    @Expose
    var email: String? = null

    @SerializedName("password")
    @Expose
    var password: String? = null

    @SerializedName("status")
    @Expose
    var status: Int? = 0

    @SerializedName("department_id")
    @Expose
    var departmentId: String? = null

    @SerializedName("role_id")
    @Expose
    var roleId: String? = null

    @SerializedName("createdAt")
    @Expose
    var createdAt: String? = null

    @SerializedName("updatedAt")
    @Expose
    var updatedAt: String? = null
}