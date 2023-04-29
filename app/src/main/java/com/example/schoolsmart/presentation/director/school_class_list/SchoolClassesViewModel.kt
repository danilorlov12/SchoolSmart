package com.example.schoolsmart.presentation.director.school_class_list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.data.State
import com.example.base.BaseViewModel
import com.example.schoolsmart.domain.entities.SchoolClass
import com.example.schoolsmart.domain.repositories.director.SchoolClassesRepository
import com.example.schoolsmart.domain.repositories.director.SchoolClassesRepositoryImpl
import kotlinx.coroutines.launch

class SchoolClassesViewModel : BaseViewModel() {

    private val repository: SchoolClassesRepository = SchoolClassesRepositoryImpl()

    private val _schoolClasses = MutableLiveData<List<SchoolClass>>()
    val schoolClasses: LiveData<List<SchoolClass>> = _schoolClasses

    init {
        loadSchoolClasses()
    }

    private fun loadSchoolClasses() {
        viewModelScope.launch {
            repository.loadSchoolClasses().collect { state ->
                when (state) {
                    is State.Success -> {
                        _schoolClasses.value = state.data ?: emptyList()
                    }
                    else -> Log.e("schoolClasses", state.toString())
                }
            }
        }
    }
}