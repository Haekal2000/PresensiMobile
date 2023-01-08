package com.example.aplikasipresensi.model.teacher

import com.example.aplikasipresensi.model.course.CourseModel
import com.example.aplikasipresensi.model.course.CourseNameModel
import com.example.aplikasipresensi.model.course.ScheduleRecordModel
import com.example.aplikasipresensi.model.course.StudentRecordModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TeacherSessionModel {
    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("course_id")
    @Expose
    var courseId: String? = null

    @SerializedName("lecturer_nik")
    @Expose
    var lecturerNik: String? = null

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

    @SerializedName("method")
    @Expose
    var method: String? = null

    @SerializedName("course")
    @Expose
    var course: CourseNameModel? = null

    @SerializedName("studentrecord")
    @Expose
    var studentRecord: MutableList<StudentRecordModel>? = null

    @SerializedName("schedulerecord")
    @Expose
    var scheduleRecord: ScheduleRecordModel? = null
}