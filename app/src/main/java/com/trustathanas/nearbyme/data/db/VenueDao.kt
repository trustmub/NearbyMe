package com.trustathanas.nearbyme.data.db

import android.arch.lifecycle.LiveData
import com.trustathanas.nearbyme.models.VenuesItem

//@Dao
interface VenueDao {
    // sqlite query to fetch all the venues details
    fun getVenueList(): LiveData<List<VenuesItem>>
}