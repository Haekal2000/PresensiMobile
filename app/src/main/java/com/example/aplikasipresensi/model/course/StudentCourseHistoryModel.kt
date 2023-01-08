package com.example.aplikasipresensi.model.course

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class StudentCourseHistoryModel {
    @SerializedName("student_id")
    @Expose
    var studentId: String? = null

    @SerializedName("course_id")
    @Expose
    var courseId: String? = null

    @SerializedName("acceptDate")
    @Expose
    var acceptDate: String? = null

    @SerializedName("isPresent")
    @Expose
    var isPresent: Boolean? = null

    @SerializedName("course")
    @Expose
    var course: StudentCourseModel? = null
}