package com.example.schoolsmart.domain.repositories.director

import com.example.schoolsmart.data.State
import com.example.schoolsmart.domain.entities.SchoolClass
import kotlinx.coroutines.flow.Flow

interface SchoolClassesRepository {
    suspend fun loadSchoolClasses(): Flow<State<List<SchoolClass>>>
    suspend fun createSchoolClass(schoolClass: SchoolClass)
}