package com.example.schoolsmart.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.schoolsmart.base.BaseViewModel
import com.example.schoolsmart.domain.entities.UserType
import com.example.schoolsmart.domain.repositories.auth.AuthRepository
import com.example.schoolsmart.domain.repositories.auth.AuthRepositoryImpl
import kotlinx.coroutines.launch

class AuthViewModel : BaseViewModel() {

    private val authRepository: AuthRepository by lazy { AuthRepositoryImpl() }

    private val _loggedUser = MutableLiveData<UserType>()
    val loggedUser: LiveData<UserType> = _loggedUser

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _loggedUser.value = authRepository.checkUser(email, password)
        }
    }
}