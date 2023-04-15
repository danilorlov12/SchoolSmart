package com.example.schoolsmart.domain.entities

enum class UserType(val tableName: String) {
    DIRECTOR("Director"),
    TEACHER("Teacher"),
    SCHOOL_MEMBER("SchoolMember"),
    UNKNOWN("Unknown")
}
