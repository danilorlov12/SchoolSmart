package com.example.schoolsmart.presentation.director.teacher_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.schoolsmart.base.BaseViewModel
import com.example.schoolsmart.domain.entities.Teacher
import com.example.schoolsmart.domain.repositories.director.TeacherRepository
import com.example.schoolsmart.domain.repositories.director.TeacherRepositoryImpl
import kotlinx.coroutines.launch

class TeachersViewModel : BaseViewModel() {

    private val teachersRepository: TeacherRepository by lazy { TeacherRepositoryImpl() }

    private val _teachers = MutableLiveData<List<Teacher>>()
    val teachers: LiveData<List<Teacher>> = _teachers

    fun loadTeachers() {
        viewModelScope.launch {
            _teachers.value = teachersRepository.loadAllTeachers()
        }
    }
}