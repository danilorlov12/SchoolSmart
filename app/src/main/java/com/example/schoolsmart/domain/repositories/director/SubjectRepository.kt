package com.example.schoolsmart.domain.repositories.director

import com.example.data.State
import com.example.schoolsmart.domain.entities.Subject
import kotlinx.coroutines.flow.Flow

interface SubjectRepository {
    suspend fun loadSubjects(): Flow<State<List<Subject>>>
    suspend fun createSubject(subject: Subject, schoolClassNum: String)
}