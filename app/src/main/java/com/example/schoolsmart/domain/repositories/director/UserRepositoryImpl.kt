package com.example.schoolsmart.domain.repositories.director

import com.example.schoolsmart.core.FirebaseManager
import com.example.schoolsmart.domain.entities.User
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class UserRepositoryImpl : UserRepository {

    override suspend fun registerUser(user: User, tableName: String) {
        val mAuth = FirebaseManager.firebaseAuth
        mAuth.createUserWithEmailAndPassword(user.email, user.password!!).addOnCompleteListener {
            CoroutineScope(Dispatchers.IO).launch {
                sendInformation(mAuth.uid ?: "", user, tableName)
            }
        }.addOnFailureListener {

        }.await()
    }

    private suspend fun sendInformation(uid: String, user: User, tableName: String) {
        val firebaseDatabase = FirebaseDatabase.getInstance()
        firebaseDatabase.getReference("Users").child(tableName).child(uid).setValue(user)
            .addOnCompleteListener {

            }.addOnFailureListener {

            }.await()
    }
}