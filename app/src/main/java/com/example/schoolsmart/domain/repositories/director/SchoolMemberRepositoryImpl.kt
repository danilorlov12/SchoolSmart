package com.example.schoolsmart.domain.repositories.director

import com.example.schoolsmart.domain.entities.SchoolMember
import com.example.schoolsmart.extensions.stateFlow
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.tasks.await

class SchoolMemberRepositoryImpl : SchoolMemberRepository {

    override suspend fun loadSchoolMembers() = stateFlow {
        val schoolMembers = arrayListOf<SchoolMember>()
        val firebaseDatabase = FirebaseDatabase.getInstance().reference
        firebaseDatabase.child("Users").child("SchoolMember").get().await().children.map { ds ->
            schoolMembers.add(
                SchoolMember(
                    id = ds.key ?: "",
                    firstName = ds.child("firstName").value as? String ?: "",
                    lastName = ds.child("lastName").value as? String ?: "",
                    middleName = ds.child("middleName").value as? String ?: "",
                    email = ds.child("email").value as? String ?: "",
                    schoolClass = ds.child("schoolClass").value as? String ?: "",
                )
            )
        }
        schoolMembers
    }
}