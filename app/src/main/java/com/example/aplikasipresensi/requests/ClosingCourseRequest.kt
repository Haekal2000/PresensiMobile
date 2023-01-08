package com.example.aplikasipresensi.requests

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ClosingCourseRequest {
    @SerializedName("lecturer_nik")
    @Expose
    var lecturerNik: String? = null

    @SerializedName("course_id")
    @Expose
    var courseId: String? = null

    @SerializedName("schedule_id")
    @Expose
    var scheduleId: String? = null

    @SerializedName("isComplete")
    @Expose
    var isComplete: Boolean? = null
}