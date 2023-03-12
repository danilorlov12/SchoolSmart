package com.example.schoolsmart.domain.entities

data class Subject(
    val id: String,
    val name: String,
    val schoolClassId: String,
    val teacherId: String,
    val teacherFullName: String
)