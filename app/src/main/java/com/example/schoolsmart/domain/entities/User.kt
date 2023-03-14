package com.example.schoolsmart.domain.entities

open class User(
    override val firstName: String,
    override val lastName: String,
    override val middleName: String,
    override val email: String,
    val password: String? = null
) : Person(firstName, lastName, middleName, email)