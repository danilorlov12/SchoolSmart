package com.example.schoolsmart.domain.entities

enum class User(val type: Int) {
    DIRECTOR(0),
    TEACHER(1),
    SCHOOL_MEMBER(2),
    UNKNOWN(-1)
}
