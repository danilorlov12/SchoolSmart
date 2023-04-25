package com.example.schoolsmart.presentation.director.teacher_list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.data.State
import com.example.schoolsmart.base.BaseViewModel
import com.example.schoolsmart.domain.entities.Teacher
import com.example.schoolsmart.domain.repositories.director.TeacherRepository
import com.example.schoolsmart.domain.repositories.director.TeacherRepositoryImpl
import kotlinx.coroutines.launch

class TeachersViewModel : BaseViewModel() {

    private val teachersRepository: TeacherRepository = TeacherRepositoryImpl()

    private val _teachers = MutableLiveData<List<Teacher>>()
    val teachers: LiveData<List<Teacher>> = _teachers

    init {
        loadTeachers()
    }

    private fun loadTeachers() {
        viewModelScope.launch {
            teachersRepository.loadAllTeachers().collect { state ->
                when (state) {
                    is State.Success -> {
                        _teachers.value = state.data ?: emptyList()
                    }
                    else -> Log.e("teachers", state.toString())
                }
            }
        }
    }
}