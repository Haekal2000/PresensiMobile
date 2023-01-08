package com.example.aplikasipresensi.ui.teacherAuth.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aplikasipresensi.network.Resource
import com.example.aplikasipresensi.repository.TeacherUserRepository
import com.example.aplikasipresensi.requests.TeacherUserRequest
import com.example.aplikasipresensi.responses.TeacherUserResponse
import kotlinx.coroutines.launch

class TeacherUserViewModel(
    private val teacherUserRepo: TeacherUserRepository
) : ViewModel() {

    private val _teacherUserResponse: MutableLiveData<Resource<TeacherUserResponse>> = MutableLiveData()
    val teacherUserResponse: LiveData<Resource<TeacherUserResponse>>
        get() = _teacherUserResponse

    fun teacherLogin(user: TeacherUserRequest)
            = viewModelScope.launch {
        _teacherUserResponse.value = teacherUserRepo.teacherLogin(user)
    }

    fun setToken(token: String) = viewModelScope.launch {
        teacherUserRepo.setToken(token)
    }
}