package com.example.aplikasipresensi.model.user

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserModel {
    @SerializedName("token")
    @Expose
    var token: String? = null
}