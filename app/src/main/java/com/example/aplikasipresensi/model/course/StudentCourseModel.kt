package com.example.aplikasipresensi.model.course

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class StudentCourseModel {
    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("department_id")
    @Expose
    var departmentId: String? = null

    @SerializedName("schedulerecord")
    @Expose
    var scheduleRecord: ScheduleRecordModel? = null
}