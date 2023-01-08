package com.example.aplikasipresensi.model.course

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CourseNameModel {
    @SerializedName("name")
    @Expose
    var name: String? = null
}