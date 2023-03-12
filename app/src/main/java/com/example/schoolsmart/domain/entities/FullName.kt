package com.example.schoolsmart.domain.entities

interface FullName {
    val firstName: String
    val lastName: String
    val middleName: String

    fun getShortName(): String {
        val lastNameInitials = lastName.firstOrNull()?.plus(".") ?: ""
        val middleNameInitials = middleName.firstOrNull()?.plus(".") ?: ""
        return "$firstName $lastNameInitials $middleNameInitials"
    }
}