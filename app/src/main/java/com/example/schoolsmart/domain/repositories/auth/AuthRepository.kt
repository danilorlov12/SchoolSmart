package com.example.schoolsmart.domain.repositories.auth

import com.example.schoolsmart.domain.entities.User

interface AuthRepository {

    suspend fun checkUser(email: String, password: String): User

    suspend fun login(email: String): User
}