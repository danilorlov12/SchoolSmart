package com.example.schoolsmart.core

import android.content.Context
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.auth.FirebaseAuth

object FirebaseManager {

    private lateinit var firebaseOptions: FirebaseOptions
    private lateinit var firebaseApp: FirebaseApp
    lateinit var firebaseAuth: FirebaseAuth

    fun init(context: Context) {
        firebaseOptions = FirebaseOptions.Builder()
            .setDatabaseUrl("https://diplomadatabase-b1df6-default-rtdb.firebaseio.com/")
            .setApiKey("AIzaSyDNuyjJKb43oxYdQrqBu8FJROqCC9424GQ")
            .setApplicationId("diplomadatabase-b1df6")
            .build()

        firebaseApp = FirebaseApp.initializeApp(context, firebaseOptions, "SchoolSmart")

        firebaseAuth = FirebaseAuth.getInstance(firebaseApp)
    }
}