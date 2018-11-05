package com.trustathanas.nearbyme.viewmodels

import android.arch.lifecycle.ViewModel
import com.trustathanas.nearbyme.repository.ImagesRepository

class ImagesViewModel(val repository: ImagesRepository) : ViewModel() {

    fun getVenueImages(venue_id: String) = repository.getVenueImages(venue_id)
}