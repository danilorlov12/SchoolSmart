package com.example.schoolsmart.domain.entities

open class Person(
    override val firstName: String,
    override val lastName: String,
    override val middleName: String,
    open val email: String
) : FullName