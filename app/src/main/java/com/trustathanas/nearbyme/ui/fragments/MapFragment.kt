package com.trustathanas.nearbyme.ui.fragments

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.trustathanas.nearbyme.R
import com.trustathanas.nearbyme.ui.commons.BaseFragment
import com.trustathanas.nearbyme.viewmodels.LocationViewModel
import kotlinx.android.synthetic.main.fragment_map.*
import org.koin.android.viewmodel.ext.android.viewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.LatLng
import kotlinx.android.synthetic.main.fragment_map.view.*


class MapFragment : BaseFragment(), OnMapReadyCallback {

    private val locationViewModel: LocationViewModel by viewModel()

    override val fragTad: String
        get() = "MapFragment"

    override fun getLayout(): Int = R.layout.fragment_map

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(getLayout(), container, false)
        view.mapView.getMapAsync(this)
        return view
    }


    override fun onMapReady(googleMap: GoogleMap?) {
        val mMap = googleMap
        Log.d(fragTad, "Camera Position: ${googleMap?.cameraPosition}")

        locationViewModel.getLocation().observe(this, Observer {

            Log.d(fragTad, "Latitude: ${it?.latitude}")

            it?.let {
                val currentLocation = LatLng(it.latitude.toDouble(), it.longitude.toDouble())
                mMap?.let { gMaps ->
                    gMaps.addMarker(MarkerOptions().position(currentLocation).title("Marker in Sydney"))
                    gMaps.moveCamera(CameraUpdateFactory.newLatLng(currentLocation))
                }
            }
        })
    }
}