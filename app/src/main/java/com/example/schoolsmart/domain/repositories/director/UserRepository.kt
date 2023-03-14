package com.example.schoolsmart.domain.repositories.director

import com.example.schoolsmart.domain.entities.User

interface UserRepository {
    suspend fun registerUser(user: User, tableName: String)
}