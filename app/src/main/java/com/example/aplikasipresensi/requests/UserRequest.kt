package com.example.aplikasipresensi.requests

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserRequest {
    @SerializedName("nrpId")
    @Expose
    var nrpId: String? = null

    @SerializedName("password")
    @Expose
    var password: String? = null
}