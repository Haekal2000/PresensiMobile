package com.example.aplikasipresensi.responses

import com.example.aplikasipresensi.base.BaseResponse
import com.example.aplikasipresensi.model.user.StudentDataModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class StudentDataResponse : BaseResponse() {
    @SerializedName("data")
    @Expose
    var data: StudentDataModel? = null
}