package com.trustathanas.nearbyme.ui.activities

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.trustathanas.nearbyme.R
import com.trustathanas.nearbyme.ui.commons.BaseActivity

class MainActivity : BaseActivity() {

    override val tag: String = "MainActivity"
    override fun getLayout(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())

        val navigation = Navigation.findNavController(this, R.id.navigation_host_fragment)
        setupBottomNavigation(navigation)
    }

    private fun setupBottomNavigation(navigation: NavController) {
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.let {
            NavigationUI.setupWithNavController(it, navigation)
        }
    }


}
