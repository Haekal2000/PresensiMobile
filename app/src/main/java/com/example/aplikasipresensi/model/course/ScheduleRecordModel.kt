package com.example.aplikasipresensi.model.course

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ScheduleRecordModel {
    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("isComplete")
    @Expose
    var isComplete: Boolean? = null

    @SerializedName("createdAt")
    @Expose
    var createdAt: String? = null
}