package com.example.schoolsmart.presentation.director.teacher_edit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.schoolsmart.base.BaseViewModel

class TeacherEditViewModel : BaseViewModel() {

    private val _firstName: MutableLiveData<String> = MutableLiveData()
    val firstName: LiveData<String> = _firstName

    private val _lastName: MutableLiveData<String> = MutableLiveData()
    val lastName: LiveData<String> = _lastName

    private val _middleName: MutableLiveData<String> = MutableLiveData()
    val middleName: LiveData<String> = _middleName

    private val _email: MutableLiveData<String> = MutableLiveData()
    val email: LiveData<String> = _email

    private val _password: MutableLiveData<String> = MutableLiveData()
    val password: LiveData<String> = _password
}