package com.example.schoolsmart.domain.repositories.director

import com.example.schoolsmart.domain.entities.Teacher
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.tasks.await

class TeacherRepositoryImpl : TeacherRepository {

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
                    email = ds.child("email").value as? String ?: "",
                )
            }
        }.addOnFailureListener {

        }.await()
        return teachers
    }
}