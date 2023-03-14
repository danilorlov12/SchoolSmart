package com.example.schoolsmart.domain.repositories.director

import com.example.schoolsmart.domain.entities.SchoolMember

interface SchoolMemberRepository {
    suspend fun loadSchoolMembers(): List<SchoolMember>
}