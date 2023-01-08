package com.example.aplikasipresensi.requests

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TeacherUserRequest {
    @SerializedName("nik")
    @Expose
    var nik: String? = null

    @SerializedName("password")
    @Expose
    var password: String? = null
}