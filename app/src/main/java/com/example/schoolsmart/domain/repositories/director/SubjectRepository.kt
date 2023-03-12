package com.example.schoolsmart.domain.repositories.director

import com.example.schoolsmart.domain.entities.Subject

interface SubjectRepository {
    suspend fun loadSubjects(): List<Subject>
    suspend fun createSubject(subject: Subject, schoolClassNum: String)
}