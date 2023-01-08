package com.example.aplikasipresensi.model.course

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
class CourseModel : Parcelable {
    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("course_id")
    @Expose
    var courseId: String? = null

    @SerializedName("lecturer_nik")
    @Expose
    var lecturerNik: String? = null

    @SerializedName("method")
    @Expose
    var method: String? = null

    @SerializedName("createdAt")
    @Expose
    var createdAt: String? = null

    @SerializedName("updatedAt")
    @Expose
    var updatedAt: String? = null

    @SerializedName("academic_period_id")
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

    @SerializedName("course")
    @Expose
    var course: StudentCourseModel? = null

    @SerializedName("studentrecord")
    @Expose
    var studentRecord: MutableList<StudentRecordModel>? = null
}