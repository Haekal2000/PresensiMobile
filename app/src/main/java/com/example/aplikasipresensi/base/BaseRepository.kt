package com.example.aplikasipresensi.base

import android.util.Log
import com.example.aplikasipresensi.network.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

abstract class BaseRepository {
    suspend fun <T> handlingApiCall(
        apiCAll: suspend () -> T
    ): Resource<T> {
        return withContext(Dispatchers.IO){
            try {
                Resource.Success(apiCAll.invoke())
            }catch (throwable: Throwable) {
                when(throwable) {
                    is HttpException -> {
                        Resource.Failure(null, null, throwable.code(), throwable.response()?.errorBody())
                    }
                    else -> {
                        Log.e("err", throwable.localizedMessage)
                        Resource.Failure(null, null, null, null)
                    }
                }
            }
        }
    }
}