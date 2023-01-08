package com.example.aplikasipresensi.requests

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AcceptCourseRequest {
    @SerializedName("course_code")
    @Expose
    var courseCode: String? = null

    @SerializedName("student_id")
    @Expose
    var studentId: String? = null

    @SerializedName("lecturer_nik")
    @Expose
    var lecturerNik: String? = null

    @SerializedName("schedule_id")
    @Expose
    var scheduleId: String? = null

    @SerializedName("isPresent")
    @Expose
    var isPresent: Boolean? = null

    @SerializedName("isDone")
    @Expose
    var isDone: Boolean? = null
}