package com.example.aplikasipresensi.requests

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SendEmailRequest {
    @SerializedName("course_id")
    @Expose
    var courseId: String? = null

    @SerializedName("academic_period_id")
    @Expose
    var academicPeriodId: String? = null

    @SerializedName("department_id")
    @Expose
    var departmentId: String? = null

    @SerializedName("courseName")
    @Expose
    var courseName: String? = null
}