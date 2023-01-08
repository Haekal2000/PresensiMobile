package com.example.aplikasipresensi.model.user

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class StudentDataModel {
    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("department_id")
    @Expose
    var departmentId: String? = null

    @SerializedName("image")
    @Expose
    var image: String? = null

    @SerializedName("academic_period_id")
    @Expose
    var academicPeriodId: String? = null

    @SerializedName("email")
    @Expose
    var email: String? = null

    @SerializedName("createdAt")
    @Expose
    var createdAt: String? = null

    @SerializedName("updatedAt")
    @Expose
    var updatedAt: String? = null

    @SerializedName("nrpId")
    @Expose
    var nrpId: String? = null

    @SerializedName("departmentName")
    @Expose
    var departmentName: String? = null
}