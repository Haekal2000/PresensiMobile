//package com.example.aplikasipresensi.ui.home.viewmodel
//
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.aplikasipresensi.network.Resource
//import com.example.aplikasipresensi.repository.StudentRepository
//import com.example.aplikasipresensi.responses.StudentResponse
//import kotlinx.coroutines.launch
//
//class StudentViewModel(
//    private val studentRepo: StudentRepository
//) : ViewModel() {
//
//    private val _studentResponse: MutableLiveData<Resource<StudentResponse>> = MutableLiveData()
//    val studentResponse: LiveData<Resource<StudentResponse>>
//        get() = _studentResponse
//
//    fun getListStudent(nrpId: Int)
//            = viewModelScope.launch {
//        _studentResponse.value = studentRepo.getListStudent(nrpId)
//    }
//
//    fun setName(name: String) = viewModelScope.launch {
//        studentRepo.setName(name)
//    }
//
//    fun setNrpId(nrpId: String) = viewModelScope.launch {
//        studentRepo.setNrpId(nrpId)
//    }
//
//    fun setDepartmentId(departmentId: String) = viewModelScope.launch {
//        studentRepo.setDepartmentId(departmentId)
//    }
//
//    fun setDepartmentName(departmentName: String) = viewModelScope.launch {
//        studentRepo.setDepartmentName(departmentName)
//    }
//
//    fun setImage(image: String) = viewModelScope.launch {
//        studentRepo.setImage(image)
//    }
//}