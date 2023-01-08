package com.example.aplikasipresensi.responses

import com.example.aplikasipresensi.base.BaseResponse
import com.example.aplikasipresensi.model.teacher.TeacherSessionModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TeacherSessionResponse: BaseResponse() {
    @SerializedName("data")
    @Expose
    var data: MutableList<TeacherSessionModel>? = null
}