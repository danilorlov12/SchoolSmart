package com.example.schoolsmart.presentation.director.school_class_edit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.schoolsmart.base.BaseViewModel
import com.example.schoolsmart.domain.entities.SchoolClass
import com.example.schoolsmart.domain.repositories.director.SchoolClassesRepository
import com.example.schoolsmart.domain.repositories.director.SchoolClassesRepositoryImpl
import kotlinx.coroutines.launch

class SchoolClassEditViewModel : BaseViewModel() {

    private val repository: SchoolClassesRepository = SchoolClassesRepositoryImpl()

    private val _name: MutableLiveData<String> = MutableLiveData()
    val name: LiveData<String> = _name

    fun sendSchoolClassInfoToDatabase() {
        viewModelScope.launch {
            val schoolClass = SchoolClass(
                id = _name.value ?: "",
                name = (_name.value ?: "") + " клас"
            )
            repository.createSchoolClass(schoolClass)
        }
    }
}