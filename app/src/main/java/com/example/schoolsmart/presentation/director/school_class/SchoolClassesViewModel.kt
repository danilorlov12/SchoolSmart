package com.example.schoolsmart.presentation.director.school_class

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.schoolsmart.base.BaseViewModel
import com.example.schoolsmart.domain.entities.SchoolClass
import com.example.schoolsmart.domain.repositories.director.SchoolClassesRepository
import com.example.schoolsmart.domain.repositories.director.SchoolClassesRepositoryImpl
import kotlinx.coroutines.launch

class SchoolClassesViewModel : BaseViewModel() {

    private val repository: SchoolClassesRepository by lazy {
        SchoolClassesRepositoryImpl()
    }

    private val _schoolClasses = MutableLiveData<List<SchoolClass>>()
    val schoolClasses: LiveData<List<SchoolClass>> = _schoolClasses

    fun loadSchoolClasses() {
        viewModelScope.launch {
            _schoolClasses.value = repository.loadSchoolClasses()
        }
    }
}