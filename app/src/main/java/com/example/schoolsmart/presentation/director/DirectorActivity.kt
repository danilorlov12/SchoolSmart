package com.example.schoolsmart.presentation.director

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.navOptions
import androidx.navigation.ui.setupWithNavController
import com.example.schoolsmart.R
import com.example.schoolsmart.base.BaseActivity
import com.example.schoolsmart.databinding.DirectorActivityBinding
import com.example.schoolsmart.presentation.director.school_class_list.SchoolClassesFragment
import com.example.schoolsmart.presentation.director.subject.SubjectsFragment
import com.example.schoolsmart.presentation.director.teacher_list.TeachersFragment

class DirectorActivity : BaseActivity<DirectorActivityBinding>(DirectorActivityBinding::inflate) {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer) as NavHostFragment
        navController = navHostFragment.navController

        //binding.bottomNavigation.setupWithNavController(navController)

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            onBottomMenuItemClick(item.itemId, navController)
            true
        }
    }

    private fun onBottomMenuItemClick(destinationId: Int, navController: NavController) {
        if (navController.currentDestination?.id == destinationId) {

        } else {
            navigateTo(destinationId, navController)
        }
    }

    private fun navigateTo(destinationId: Int, navController: NavController) {
        navController.navigate(destinationId, null, navOptions {
            launchSingleTop = true
            restoreState = true
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
        })
    }


    companion object {
        private val fragments = HashMap<Int, Fragment>().apply {
            put(0, TeachersFragment())
            put(1, SchoolClassesFragment())
            put(2, SubjectsFragment())
        }
    }

    //        var activeFragment = fragments[0]!!
//        supportFragmentManager.beginTransaction()
//            .add(R.id.fragmentContainer, fragments[2]!!, "")
//            .hide(fragments[2]!!).commit()
//
//        supportFragmentManager.beginTransaction()
//            .add(R.id.fragmentContainer, fragments[1]!!, "")
//            .hide(fragments[1]!!).commit()
//
//        supportFragmentManager.beginTransaction()
//            .add(R.id.fragmentContainer, fragments[0]!!, "")
//            .commit()
//        binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->
//            when (item.itemId) {
//                R.id.navigationTeachers -> {
//                    supportFragmentManager.beginTransaction().hide(activeFragment)
//                        .show(fragments[0]!!).commit()
//                    activeFragment = fragments[0]!!
//                }
//                R.id.navigationSchoolClasses -> {
//                    supportFragmentManager.beginTransaction().hide(activeFragment)
//                        .show(fragments[1]!!).commit()
//                    activeFragment = fragments[1]!!
//                }
//                R.id.navigationSubjects -> {
//                    supportFragmentManager.beginTransaction().hide(activeFragment)
//                        .show(fragments[2]!!).commit()
//                    activeFragment = fragments[2]!!
//                }
//            }
//            true
//        }
}