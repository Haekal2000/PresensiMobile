package com.example.aplikasipresensi.responses

import com.example.aplikasipresensi.base.BaseResponse
import com.example.aplikasipresensi.model.teacher.TeacherDataModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TeacherDataResponse : BaseResponse() {
    @SerializedName("data")
    @Expose
    var data: TeacherDataModel? = null
}