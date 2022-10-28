package com.example.aplikasipresensi.network

import okhttp3.ResponseBody

sealed class Resource<out T> {
    data class Success<out T>(val value: T): Resource<T>()
    data class Failure(
        val status: String?,
        val message: String?,
        var errorCode: Int?,
        val body: ResponseBody?
    ): Resource<Nothing>()
}