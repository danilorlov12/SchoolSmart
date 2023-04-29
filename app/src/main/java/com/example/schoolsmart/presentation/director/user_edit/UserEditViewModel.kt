package com.example.schoolsmart.presentation.director.user_edit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.base.BaseViewModel
import com.example.schoolsmart.domain.entities.User
import com.example.schoolsmart.domain.repositories.director.UserRepository
import com.example.schoolsmart.domain.repositories.director.UserRepositoryImpl
import kotlinx.coroutines.launch

class UserEditViewModel : BaseViewModel() {

    private val repository: UserRepository = UserRepositoryImpl()

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

    fun setDataFromUser(user: User) {
        _firstName.value = user.firstName
        _lastName.value = user.lastName
        _middleName.value = user.middleName
        _email.value = user.email
        _password.value = user.password ?: ""
    }

    fun prepareAndSendUserInfo(userType: String) {
        viewModelScope.launch {
            val user = User(
                firstName = _firstName.value ?: "",
                lastName = _lastName.value ?: "",
                middleName = _middleName.value ?: "",
                email = _email.value ?: "",
                password = _password.value ?: ""
            )
            repository.registerUser(user, userType)
        }
    }
}