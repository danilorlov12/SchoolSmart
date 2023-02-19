package com.example.schoolsmart.domain.repositories.auth

import com.example.schoolsmart.domain.entities.User
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await

class AuthRepositoryImpl : AuthRepository {

    private val authRef = FirebaseAuth.getInstance()

    override suspend fun checkUser(email: String, password: String): User {
        return try {
            val authResult = authRef.signInWithEmailAndPassword(email, password).await()
            if (authResult.user != null) {
                login(email)
            } else {
                User.UNKNOWN
            }
        } catch (e: Exception) {
            User.UNKNOWN
        }
    }

    override suspend fun login(email: String): User {
        return User.DIRECTOR
    }
}