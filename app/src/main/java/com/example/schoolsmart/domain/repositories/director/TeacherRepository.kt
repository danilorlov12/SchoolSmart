package com.example.schoolsmart.domain.repositories.director

import com.example.base.State
import com.example.schoolsmart.domain.entities.Teacher
import kotlinx.coroutines.flow.Flow

interface TeacherRepository {
    suspend fun loadAllTeachers(): Flow<State<List<Teacher>>>
}