package com.example.schoolsmart.presentation.director

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.schoolsmart.R
import com.example.schoolsmart.base.BaseActivity
import com.example.schoolsmart.databinding.DirectorActivityBinding

class DirectorActivity : BaseActivity<DirectorActivityBinding>(DirectorActivityBinding::inflate) {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer) as NavHostFragment
        navController = navHostFragment.navController

        binding.bottomNavigation.setupWithNavController(navController)
    }
}