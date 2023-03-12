package com.example.schoolsmart.domain.repositories.director

import android.util.Log
import com.example.schoolsmart.domain.entities.SchoolClass
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.tasks.await

class SchoolClassesRepositoryImpl : SchoolClassesRepository {
    override suspend fun loadSchoolClasses(): List<SchoolClass> {
        var schoolClasses = listOf<SchoolClass>()
        val firebaseDatabase = FirebaseDatabase.getInstance().reference
        firebaseDatabase.child("SchoolClass").get().addOnSuccessListener {
            schoolClasses = it.children.map { ds ->
                SchoolClass(
                    ds.child("id").value as String? ?: "",
                    ds.child("name").value as String? ?: ""
                )
            }
        }.addOnFailureListener {
            Log.e("exception", it.message.toString())
        }.await()
        return schoolClasses
    }

    override suspend fun createSchoolClass(schoolClass: SchoolClass) {
        val ref = FirebaseDatabase.getInstance().getReference("SchoolClass")
        ref.child(schoolClass.name).setValue(schoolClass)
    }
}