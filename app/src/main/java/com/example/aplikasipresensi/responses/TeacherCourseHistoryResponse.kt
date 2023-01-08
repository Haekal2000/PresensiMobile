package com.example.aplikasipresensi.responses

import com.example.aplikasipresensi.base.BaseResponse
import com.example.aplikasipresensi.model.teacher.TeacherCourseHistoryModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TeacherCourseHistoryResponse: BaseResponse() {
    @SerializedName("data")
    @Expose
    var data: TeacherCourseHistoryModel? = null
}