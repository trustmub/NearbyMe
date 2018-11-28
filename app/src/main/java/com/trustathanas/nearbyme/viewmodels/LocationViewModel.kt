package com.trustathanas.nearbyme.viewmodels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.trustathanas.nearbyme.models.LocationModel
import com.trustathanas.nearbyme.repository.LocationRepository

class LocationViewModel(private val repository: LocationRepository) : ViewModel() {

    fun getLocation(): LiveData<LocationModel> = repository.getLocation()
}