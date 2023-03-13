package com.example.schoolsmart.domain.repositories.director

import android.util.Log
import com.example.schoolsmart.domain.entities.Subject
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.tasks.await

class SubjectRepositoryImpl : SubjectRepository {

    override suspend fun loadSubjects(): List<Subject> {
        var subjects = listOf<Subject>()
        val firebaseDatabase = FirebaseDatabase.getInstance().reference
        firebaseDatabase.child("Subject").get().addOnSuccessListener {
            subjects = it.children.map { ds ->
                Subject(
                    id = ds.key ?: "",
                    name = ds.child("name").value as? String ?: "",
                    schoolClassId = ds.child("schoolClassId").value as? String ?: "",
                    teacherId = ds.child("teacherId").value as String,
                    teacherFullName = ds.child("teacherFullName").value as String
                )
            }
        }.addOnFailureListener {
            Log.e("exception", it.message.toString())
        }.await()
        return subjects
    }

    override suspend fun createSubject(subject: Subject, schoolClassNum: String) {
        val ref = FirebaseDatabase.getInstance().getReference("Subject")
        ref.child(subject.name + "($schoolClassNum)").setValue(subject)
    }
}