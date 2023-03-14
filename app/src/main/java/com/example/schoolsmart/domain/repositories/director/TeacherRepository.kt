package com.example.schoolsmart.domain.repositories.director

import com.example.schoolsmart.domain.entities.Teacher

interface TeacherRepository {
    suspend fun loadAllTeachers(): List<Teacher>
}