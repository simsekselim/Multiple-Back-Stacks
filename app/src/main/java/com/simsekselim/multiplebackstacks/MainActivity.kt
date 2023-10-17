package com.simsekselim.multiplebackstacks

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navHostFragment = supportFragmentManager.findFragmentById(
            R.id.nav_host_container
        ) as NavHostFragment
        navController = navHostFragment.navController

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_nav)
        bottomNavigationView.setupWithNavController(navController)

        bottomNavigationView.setOnItemSelectedListener { item ->
            NavigationUI.onNavDestinationSelected(item, navController)
            true
        }

        bottomNavigationView.setOnItemReselectedListener { item ->
            backToBottomNavigationMenuDestination(navController, item.itemId)
        }
    }

    private fun backToBottomNavigationMenuDestination(
        navController: NavController,
        @IdRes id: Int,
    ) {
        val node = navController.currentDestination?.parent?.findNode(id) ?: return
        if (node !is NavGraph) {
            return
        }
        if (node.startDestinationId == navController.currentDestination?.id) {
//           Whatever you want to do, with use id or general
//           Example-1
//           if (id == R.id.home){
//              Toast.makeText(this,"Scroll Top", Toast.LENGTH_LONG).show()
//           }
//           Example-2
//           navController.navigate(id)
        }
        navController.popBackStack(node.startDestinationId, inclusive = false)
    }

}