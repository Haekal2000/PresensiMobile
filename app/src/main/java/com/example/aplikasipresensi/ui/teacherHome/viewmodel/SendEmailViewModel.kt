package com.example.aplikasipresensi.ui.teacherHome.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aplikasipresensi.base.BaseResponse
import com.example.aplikasipresensi.network.Resource
import com.example.aplikasipresensi.repository.SendEmailRepository
import com.example.aplikasipresensi.requests.SendEmailRequest
import kotlinx.coroutines.launch

class SendEmailViewModel(
    private val sendEmailRepo: SendEmailRepository
) : ViewModel() {

    private val _sendEmailResponse: MutableLiveData<Resource<BaseResponse>> = MutableLiveData()
    val sendEmailResponse: LiveData<Resource<BaseResponse>>
        get() = _sendEmailResponse

    fun sendEmail(sendEmail: SendEmailRequest)
            = viewModelScope.launch {
        _sendEmailResponse.value = sendEmailRepo.sendEmail(sendEmail)
    }
}