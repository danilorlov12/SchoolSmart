package com.example.schoolsmart.presentation.director.subject

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.schoolsmart.base.BaseViewModel
import com.example.schoolsmart.data.State
import com.example.schoolsmart.domain.entities.Subject
import com.example.schoolsmart.domain.repositories.director.SubjectRepository
import com.example.schoolsmart.domain.repositories.director.SubjectRepositoryImpl
import kotlinx.coroutines.launch

class SubjectsViewModel : BaseViewModel() {

    private val subjectRepository: SubjectRepository = SubjectRepositoryImpl()

    private val _subjects: MutableLiveData<List<Subject>> = MutableLiveData()
    val subjects: LiveData<List<Subject>> = _subjects

    init {
        loadSubjects()
    }

    private fun loadSubjects() {
        viewModelScope.launch {
            subjectRepository.loadSubjects().collect { state ->
                when (state) {
                    is State.Success -> {
                        _subjects.value = state.data ?: emptyList()
                    }
                    else -> Log.e("subjects", state.toString())
                }
            }
        }
    }
}