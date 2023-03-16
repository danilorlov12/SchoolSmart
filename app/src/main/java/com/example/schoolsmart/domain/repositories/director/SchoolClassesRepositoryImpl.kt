package com.example.schoolsmart.domain.repositories.director

import com.example.schoolsmart.data.State
import com.example.schoolsmart.domain.entities.SchoolClass
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.tasks.await

class SchoolClassesRepositoryImpl : SchoolClassesRepository {

    override suspend fun loadSchoolClasses() = flow<State<List<SchoolClass>>> {
        emit(State.loading())
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
        emit(State.success(schoolClasses))
    }.flowOn(Dispatchers.Default)

    override suspend fun createSchoolClass(schoolClass: SchoolClass) {
        val ref = FirebaseDatabase.getInstance().getReference("SchoolClass")
        ref.child(schoolClass.name).setValue(schoolClass)
    }
}