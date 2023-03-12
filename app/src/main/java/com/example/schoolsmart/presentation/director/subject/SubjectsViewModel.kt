package com.example.schoolsmart.presentation.director.subject

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.schoolsmart.base.BaseViewModel
import com.example.schoolsmart.domain.entities.Subject
import com.example.schoolsmart.domain.repositories.director.SubjectRepository
import com.example.schoolsmart.domain.repositories.director.SubjectRepositoryImpl
import kotlinx.coroutines.launch

class SubjectsViewModel : BaseViewModel() {

    private val subjectRepository: SubjectRepository by lazy { SubjectRepositoryImpl() }

    private val _subjects: MutableLiveData<List<Subject>> = MutableLiveData()
    val subjects: LiveData<List<Subject>> = _subjects

    fun loadSubjects() {
        viewModelScope.launch {
            _subjects.value = subjectRepository.loadSubjects()
        }
    }
}