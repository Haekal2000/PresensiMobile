package com.example.aplikasipresensi.responses

import com.example.aplikasipresensi.base.BaseResponse
import com.example.aplikasipresensi.model.course.StudentCourseHistoryModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class StudentCourseHistoryResponse: BaseResponse() {
    @SerializedName("data")
    @Expose
    var data: MutableList<StudentCourseHistoryModel>? = null
}