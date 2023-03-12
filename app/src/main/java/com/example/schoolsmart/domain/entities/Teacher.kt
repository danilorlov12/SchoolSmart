package com.example.schoolsmart.domain.entities

data class Teacher(
    val id: String,
    override val firstName: String,
    override val lastName: String,
    override val middleName: String,
    val email: String
) : FullName