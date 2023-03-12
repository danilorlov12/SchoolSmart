package com.example.schoolsmart.domain.repositories.director

import android.app.Application
import com.example.schoolsmart.domain.entities.Teacher
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.tasks.await

class TeacherRepositoryImpl : TeacherRepository {

    private val firebaseOptions: FirebaseOptions = FirebaseOptions.Builder()
        .setDatabaseUrl("https://diplomadatabase-b1df6-default-rtdb.firebaseio.com/")
        .setApiKey("AIzaSyDNuyjJKb43oxYdQrqBu8FJROqCC9424GQ")
        .setApplicationId("diplomadatabase-b1df6").build()

    override suspend fun loadAllTeachers(): List<Teacher> {
        var teachers = listOf<Teacher>()
        val firebaseDatabase = FirebaseDatabase.getInstance().reference
        firebaseDatabase.child("Users").child("Teacher").get().addOnSuccessListener {
            teachers = it.children.map { ds ->
                Teacher(
                    id = ds.child("id").value as? String ?: "",
                    firstName = ds.child("firstName").value as? String ?: "",
                    lastName = ds.child("lastName").value as? String ?: "",
                    middleName = ds.child("middleName").value as? String ?: "",
                    email = ds.child("email").value as? String ?: ""
                )
            }
        }.addOnFailureListener {

        }.await()
        return teachers
    }

    override suspend fun createTeacher(teacher: Teacher, password: String) {
        val app = FirebaseApp.initializeApp(
            Application().applicationContext,
            firebaseOptions, ""
        )
        val mAuth2 = FirebaseAuth.getInstance(app)
        mAuth2.createUserWithEmailAndPassword(teacher.email, password).addOnCompleteListener {
            val firebaseDatabase = FirebaseDatabase.getInstance()
            firebaseDatabase.getReference("Users").child("Teacher").child(mAuth2.uid ?: "")
                .setValue(teacher)
                .addOnCompleteListener {

                }.addOnFailureListener {

                }
        }.addOnFailureListener {

        }.await()
    }
}