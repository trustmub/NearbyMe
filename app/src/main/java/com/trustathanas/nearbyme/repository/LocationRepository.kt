package com.trustathanas.nearbyme.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.trustathanas.nearbyme.models.LocationModel
import com.trustathanas.nearbyme.utilities.SharedPreferencesMain

class LocationRepository(private val sharedPreferencesMain: SharedPreferencesMain) {

    fun getLocation(): LiveData<LocationModel> {
        val result: MutableLiveData<LocationModel> = MutableLiveData()
        val lat = sharedPreferencesMain.latitude!!
        val long = sharedPreferencesMain.longitude!!
        result.postValue(LocationModel(lat, long))
        return result
    }
}