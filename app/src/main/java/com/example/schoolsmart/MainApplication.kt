package com.example.schoolsmart

import android.app.Application
import com.example.schoolsmart.core.FirebaseManager

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        FirebaseManager.init(this)
    }
}