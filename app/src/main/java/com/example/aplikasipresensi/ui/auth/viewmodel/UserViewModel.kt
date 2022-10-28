package com.example.aplikasipresensi.ui.auth.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aplikasipresensi.network.Resource
import com.example.aplikasipresensi.repository.UserRepository
import com.example.aplikasipresensi.requests.UserRequest
import com.example.aplikasipresensi.responses.UserResponse
import kotlinx.coroutines.launch

class UserViewModel(
    private val userRepo: UserRepository
) : ViewModel() {

    private val _userResponse: MutableLiveData<Resource<UserResponse>> = MutableLiveData()
    val userResponse: LiveData<Resource<UserResponse>>
        get() = _userResponse

    fun login(user: UserRequest)
            = viewModelScope.launch {
        _userResponse.value = userRepo.login(user)
    }

    fun setToken(token: String) = viewModelScope.launch {
        userRepo.setToken(token)
    }

    fun setNrpId(nrpId: String) = viewModelScope.launch {
        userRepo.setNrpId(nrpId)
    }
}