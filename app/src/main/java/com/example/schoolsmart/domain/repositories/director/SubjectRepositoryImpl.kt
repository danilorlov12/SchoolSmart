package com.example.schoolsmart.domain.repositories.director

import com.example.extensions.stateFlow
import com.example.schoolsmart.domain.entities.Subject
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.tasks.await

class SubjectRepositoryImpl : SubjectRepository {

    override suspend fun loadSubjects() = stateFlow {
        val subjects = arrayListOf<Subject>()
        val firebaseDatabase = FirebaseDatabase.getInstance().reference
        firebaseDatabase.child("Subject").get().await().children.map { ds ->
            subjects.add(
                Subject(
                    id = ds.key ?: "",
                    name = ds.child("name").value as? String ?: "",
                    schoolClassId = ds.child("schoolClassId").value as? String ?: "",
                    teacherId = ds.child("teacherId").value as? String ?: "",
                    teacherFullName = ds.child("teacherFullName").value as? String ?: ""
                )
            )
        }
        subjects
    }

    override suspend fun createSubject(subject: Subject, schoolClassNum: String) {
        val ref = FirebaseDatabase.getInstance().getReference("Subject")
        ref.child(subject.name + "($schoolClassNum)").setValue(subject)
    }
}