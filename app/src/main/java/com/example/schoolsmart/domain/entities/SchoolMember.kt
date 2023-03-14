package com.example.schoolsmart.domain.entities

data class SchoolMember(
    val id: String,
    override val firstName: String,
    override val lastName: String,
    override val middleName: String,
    override val email: String,
    val schoolClass: String
): User(firstName, lastName, middleName, email)