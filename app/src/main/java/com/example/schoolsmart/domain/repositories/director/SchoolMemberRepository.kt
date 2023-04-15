package com.example.schoolsmart.domain.repositories.director

import com.example.base.State
import com.example.schoolsmart.domain.entities.SchoolMember
import kotlinx.coroutines.flow.Flow

interface SchoolMemberRepository {
    suspend fun loadSchoolMembers(): Flow<State<List<SchoolMember>>>
}