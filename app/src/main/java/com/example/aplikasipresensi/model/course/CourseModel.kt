package com.example.aplikasipresensi.model.course

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CourseModel {
    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("credits")
    @Expose
    var credits: String? = null

    @SerializedName("department_id")
    @Expose
    var departmentId: String? = null

    @SerializedName("academicPeriodId")
    @Expose
    var academicPeriodId: String? = null

    @SerializedName("day")
    @Expose
    var day: String? = null

    @SerializedName("hours")
    @Expose
    var hours: String? = null

    @SerializedName("room")
    @Expose
    var room: String? = null
}