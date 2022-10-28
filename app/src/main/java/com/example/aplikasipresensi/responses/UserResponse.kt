package com.example.aplikasipresensi.responses

import com.example.aplikasipresensi.model.user.UserModel
import com.example.aplikasipresensi.base.BaseResponse
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserResponse : BaseResponse() {
    @SerializedName("data")
    @Expose
    var data: UserModel? = null

}