package com.example.schoolsmart.domain.repositories.director

import com.example.base.stateFlow
import com.example.schoolsmart.domain.entities.SchoolClass
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.tasks.await

class SchoolClassesRepositoryImpl : SchoolClassesRepository {

    override suspend fun loadSchoolClasses() = stateFlow {
        val schoolClasses = arrayListOf<SchoolClass>()
        val firebaseDatabase = FirebaseDatabase.getInstance().reference
        firebaseDatabase.child("SchoolClass").get().await().children.map { ds ->
            schoolClasses.add(
                SchoolClass(
                    ds.child("id").value as String? ?: "",
                    ds.child("name").value as String? ?: ""
                )
            )
        }
        schoolClasses
    }

    override suspend fun createSchoolClass(schoolClass: SchoolClass) {
        val ref = FirebaseDatabase.getInstance().getReference("SchoolClass")
        ref.child(schoolClass.name).setValue(schoolClass)
    }
}