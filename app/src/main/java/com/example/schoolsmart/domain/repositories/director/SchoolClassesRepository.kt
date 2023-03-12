package com.example.schoolsmart.domain.repositories.director

import com.example.schoolsmart.domain.entities.SchoolClass

interface SchoolClassesRepository {
    suspend fun loadSchoolClasses(): List<SchoolClass>
    suspend fun createSchoolClass(schoolClass: SchoolClass)
}