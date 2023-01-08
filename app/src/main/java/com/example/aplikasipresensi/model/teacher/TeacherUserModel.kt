package com.example.aplikasipresensi.model.teacher

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TeacherUserModel {
    @SerializedName("token")
    @Expose
    var token: String? = null
}