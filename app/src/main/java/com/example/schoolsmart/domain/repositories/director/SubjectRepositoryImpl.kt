package com.example.schoolsmart.domain.repositories.director

import android.util.Log
import com.example.schoolsmart.domain.entities.Subject
import com.google.firebase.database.FirebaseDatabase

class SubjectRepositoryImpl : SubjectRepository {

    override suspend fun loadSubjects(): List<Subject> {
        var subjects = listOf<Subject>()
        val firebaseDatabase = FirebaseDatabase.getInstance().reference
        firebaseDatabase.child("Subject").get().addOnSuccessListener {
            subjects = it.children.map { ds ->
                Subject(
                    ds.key ?: "",
                    ds.child("name").value as? String ?: "",
                    ds.child("schoolClassId").value as? String ?: "",
                    ds.child("teacherId").value as String,
                    ds.child("teacherFullName").value as String
                )
            }
        }.addOnFailureListener {
            Log.e("exception", it.message.toString())
        }
        return subjects
    }

    override suspend fun createSubject(subject: Subject, schoolClassNum: String) {
        val ref = FirebaseDatabase.getInstance().getReference("Subject")
        ref.child(subject.name + "($schoolClassNum)").setValue(subject)
    }
}