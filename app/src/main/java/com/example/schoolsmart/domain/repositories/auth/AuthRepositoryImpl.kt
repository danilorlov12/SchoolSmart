package com.example.schoolsmart.domain.repositories.auth

import com.example.schoolsmart.domain.entities.UserType
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await

class AuthRepositoryImpl : AuthRepository {

    private val authRef = FirebaseAuth.getInstance()

    override suspend fun checkUser(email: String, password: String): UserType {
        return try {
            val authResult = authRef.signInWithEmailAndPassword(email, password).await()
            if (authResult.user != null) {
                login(email)
            } else {
                UserType.UNKNOWN
            }
        } catch (e: Exception) {
            UserType.UNKNOWN
        }
    }

    override suspend fun login(email: String): UserType {
        return UserType.DIRECTOR
    }
}