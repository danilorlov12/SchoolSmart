package com.example.schoolsmart.presentation.director.user_edit

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.base.BaseViewModel
import com.example.schoolsmart.domain.entities.User
import com.example.schoolsmart.domain.repositories.director.UserRepository
import com.example.schoolsmart.domain.repositories.director.UserRepositoryImpl
import kotlinx.coroutines.launch

class UserEditViewModel : BaseViewModel() {

    private val repository: UserRepository = UserRepositoryImpl()

    val firstName: MutableLiveData<String> = MutableLiveData()
    val lastName: MutableLiveData<String> = MutableLiveData()
    val middleName: MutableLiveData<String> = MutableLiveData()
    val email: MutableLiveData<String> = MutableLiveData()
    val password: MutableLiveData<String> = MutableLiveData()

    fun prepareAndSendUserInfo(userType: String) {
        viewModelScope.launch {
            val user = User(
                firstName = firstName.value ?: "",
                lastName = lastName.value ?: "",
                middleName = middleName.value ?: "",
                email = email.value ?: "",
                password = password.value ?: ""
            )
            repository.registerUser(user, userType)
        }
    }
}