package com.trustathanas.nearbyme.utilities

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.support.v4.content.ContextCompat
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.trustathanas.nearbyme.App
import com.trustathanas.nearbyme.models.LocationModel


class GoogleLocation(val sharedPreferencesMain: SharedPreferencesMain, val context: Context) : GoogleApiClient.ConnectionCallbacks,
    GoogleApiClient.OnConnectionFailedListener {


    var fusedLocationProvider: FusedLocationProviderClient?
        get() = LocationServices.getFusedLocationProviderClient(context)
        set(value) = Unit

    override fun onConnectionFailed(results: ConnectionResult) {
        println("This is the Location Connection results failed $results")
    }

    override fun onConnected(connectionHint: Bundle?) {

        println("Connection Bundle : ${connectionHint}")

        if (ContextCompat.checkSelfPermission(
                context, Manifest.permission.ACCESS_COARSE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            fusedLocationProvider?.lastLocation?.addOnSuccessListener { location: Location? ->
                location?.let { loc: Location ->
                    val latitude = loc.latitude
                    val longitude = loc.longitude

                    sharedPreferencesMain.latitude = loc.latitude.toString()
                    sharedPreferencesMain.longitude = loc.longitude.toString()


                    App.locationValue.value =
                            LocationModel(latitude = latitude.toString(), longitude = longitude.toString())

                }
            }
        } else {
            App.locationValue.value = LocationModel()
        }
    }

    override fun onConnectionSuspended(p0: Int) {
        print("Connection Suspended : $p0")
    }


    @Volatile
    private var instance: GoogleApiClient? = null

    fun getInstance(ctx: Context): GoogleApiClient =
        instance ?: synchronized(this) {
            instance ?: GoogleApiClient.Builder(ctx).addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build()
        }

}


