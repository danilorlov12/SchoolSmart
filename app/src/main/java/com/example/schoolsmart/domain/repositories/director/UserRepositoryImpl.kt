package com.example.schoolsmart.domain.repositories.director

import android.app.Application
import com.example.schoolsmart.domain.entities.User
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class UserRepositoryImpl : UserRepository {

    private val firebaseOptions: FirebaseOptions = FirebaseOptions.Builder()
        .setDatabaseUrl("https://diplomadatabase-b1df6-default-rtdb.firebaseio.com/")
        .setApiKey("AIzaSyDNuyjJKb43oxYdQrqBu8FJROqCC9424GQ")
        .setApplicationId("diplomadatabase-b1df6").build()

    override suspend fun registerUser(user: User, tableName: String) {
        val app = FirebaseApp.initializeApp(
            Application().applicationContext,
            firebaseOptions, ""
        )
        val mAuth2 = FirebaseAuth.getInstance(app)
        mAuth2.createUserWithEmailAndPassword(user.email, user.password!!).addOnCompleteListener {
            CoroutineScope(Dispatchers.IO).launch {
                sendInformation(mAuth2.uid ?: "", user, tableName)
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