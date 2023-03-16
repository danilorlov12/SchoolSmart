package com.example.schoolsmart.domain.repositories.director

import com.example.schoolsmart.data.State
import com.example.schoolsmart.domain.entities.Teacher
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.tasks.await

class TeacherRepositoryImpl : TeacherRepository {

    override suspend fun loadAllTeachers() = flow<State<List<Teacher>>> {
        emit(State.loading())
        val teachers = arrayListOf<Teacher>()
        val firebaseDatabase = FirebaseDatabase.getInstance().reference
        firebaseDatabase.child("Users").child("Teacher").get().await().children.map { ds ->
            teachers.add(
                Teacher(
                    id = ds.child("id").value as? String ?: "",
                    firstName = ds.child("firstName").value as? String ?: "",
                    lastName = ds.child("lastName").value as? String ?: "",
                    middleName = ds.child("middleName").value as? String ?: "",
                    email = ds.child("email").value as? String ?: "",
                )
            )
        }
        emit(State.success(teachers))
    }.flowOn(Dispatchers.Default)
}