package com.example.schoolsmart.domain.repositories.auth

import com.example.schoolsmart.domain.entities.UserType

interface AuthRepository {
    suspend fun checkUser(email: String, password: String): UserType
    suspend fun login(email: String): UserType
}