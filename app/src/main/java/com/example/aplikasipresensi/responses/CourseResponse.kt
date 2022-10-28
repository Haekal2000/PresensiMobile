package com.example.aplikasipresensi.responses

import com.example.aplikasipresensi.base.BaseResponse
import com.example.aplikasipresensi.model.course.CourseModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CourseResponse: BaseResponse() {
    @SerializedName("data")
    @Expose
    var data: MutableList<CourseModel>? = null
}