package com.trustathanas.nearbyme.activities

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.trustathanas.nearbyme.App
import com.trustathanas.nearbyme.R
import com.trustathanas.nearbyme.viewmodels.CategoriesViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {

    override val tag: String = "MainActivity"
    override fun getLayout(): Int = R.layout.activity_main

//    private val categoriesViewModel: CategoriesViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())

        val navigation = Navigation.findNavController(this, R.id.navigation_host_fragment)
        setupBottomNavigation(navigation)
//        setupActionBar(navigation)

//        val tvLatitude = findViewById<TextView>(R.id.tv_latitude)
//        val tvLongitude = findViewById<TextView>(R.id.tv_longitude)

//        categoriesViewModel.getCategories().observe(this, Observer {
//            println("In Observer")
//            Log.d(tag, "${it?.response?.venues}")
//            it?.let {
//                val venueArray = it.response.venues
//
//                venueArray?.forEach {
//                    println("From for each ${it.name}")
//                }
//                tvLatitude.text = it.response.venues!![0].name
//                tvLongitude.text = it.response.venues[0].categories!![0].name
//            }
//
//        })


//        tvLatitude.text = "Loading..."
//
//        App.locationValue.observe(this, Observer {
//            if (it != null) {
//                tvLatitude.text = it.latitude
//                tvLongitude.text = it.longitude
//            } else {
//                tvLatitude.text = "observing the app variable"
//                tvLongitude.visibility = View.GONE
//            }
//        })

    }

    private fun setupBottomNavigation(navigation: NavController) {
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.let {
            NavigationUI.setupWithNavController(it, navigation)
        }
    }

//    private fun setupActionBar(navController: NavController) {
//        NavigationUI.setupActionBarWithNavController(this, navController)
//    }

}
