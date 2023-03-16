package com.example.schoolsmart.presentation.director.school_member_list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.schoolsmart.base.BaseViewModel
import com.example.schoolsmart.data.State
import com.example.schoolsmart.domain.entities.SchoolMember
import com.example.schoolsmart.domain.repositories.director.SchoolMemberRepository
import com.example.schoolsmart.domain.repositories.director.SchoolMemberRepositoryImpl
import kotlinx.coroutines.launch

class SchoolMemberListViewModel : BaseViewModel() {

    private val repository: SchoolMemberRepository = SchoolMemberRepositoryImpl()

    private val _schoolMembers = MutableLiveData<List<SchoolMember>>()
    val schoolMembers: LiveData<List<SchoolMember>> = _schoolMembers

    fun loadSchoolMembers() {
        viewModelScope.launch {
            repository.loadSchoolMembers().collect { state ->
                when (state) {
                    is State.Success -> {
                        _schoolMembers.value = state.data ?: emptyList()
                    }
                    else -> Log.e("schoolMembers", state.toString())
                }
            }
        }
    }
}