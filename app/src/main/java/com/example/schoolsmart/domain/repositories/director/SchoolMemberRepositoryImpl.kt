package com.example.schoolsmart.domain.repositories.director

import com.example.schoolsmart.domain.entities.SchoolMember
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.tasks.await

class SchoolMemberRepositoryImpl : SchoolMemberRepository {

    override suspend fun loadSchoolMembers(): List<SchoolMember> {
        var schoolMembers = listOf<SchoolMember>()
        val firebaseDatabase = FirebaseDatabase.getInstance().reference
        firebaseDatabase.child("Users").child("SchoolMember").get()
            .addOnSuccessListener {
                schoolMembers = it.children.map { ds ->
                    SchoolMember(
                        id = ds.key ?: "",
                        firstName = ds.child("firstName").value as? String ?: "",
                        lastName = ds.child("lastName").value as? String ?: "",
                        middleName = ds.child("middleName").value as? String ?: "",
                        email = ds.child("email").value as? String ?: "",
                        schoolClass = ds.child("schoolClass").value as? String ?: "",
                    )
                }
            }.addOnFailureListener {

        }.await()
        return schoolMembers
    }
}