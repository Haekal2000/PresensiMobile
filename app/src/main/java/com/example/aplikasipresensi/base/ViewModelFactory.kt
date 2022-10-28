package com.example.aplikasipresensi.base

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.aplikasipresensi.api.UserApi
import com.example.aplikasipresensi.network.RemoteDataSource
import com.example.aplikasipresensi.preferences.DataPreferences
import com.example.aplikasipresensi.repository.UserRepository
import com.example.aplikasipresensi.util.CORE_BASE_URL
import com.example.aplikasipresensi.ui.auth.viewmodel.UserViewModel

class ViewModelFactory(
    var context: Context
) : ViewModelProvider.NewInstanceFactory() {
    protected  val remoteDataSource = RemoteDataSource(context)
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(UserViewModel::class.java) -> UserViewModel(
                UserRepository(
                    remoteDataSource.buildApi(UserApi::class.java, CORE_BASE_URL),
                    DataPreferences(context)
                )
            ) as T
            else -> throw IllegalArgumentException("Viewmodel class is not found")
        }
    }
}