package com.example.aplikasipresensi.responses

import com.example.aplikasipresensi.base.BaseResponse
import com.example.aplikasipresensi.model.teacher.TeacherUserModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TeacherUserResponse : BaseResponse() {
    @SerializedName("data")
    @Expose
    var data: TeacherUserModel? = null
}