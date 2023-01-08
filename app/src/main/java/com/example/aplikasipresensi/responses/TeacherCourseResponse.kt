package com.example.aplikasipresensi.responses

import com.example.aplikasipresensi.base.BaseResponse
import com.example.aplikasipresensi.model.teacher.TeacherCourseModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TeacherCourseResponse: BaseResponse() {
    @SerializedName("data")
    @Expose
    var data: MutableList<TeacherCourseModel>? = null
}