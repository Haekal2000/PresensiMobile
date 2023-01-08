package com.example.aplikasipresensi.model.course

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class StudentRecordModel {
    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("isPresent")
    @Expose
    var isPresent: Boolean? = null

    @SerializedName("student")
    @Expose
    var student: StudentModel? = null
}