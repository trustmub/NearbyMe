package com.trustathanas.nearbyme.viewmodels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.trustathanas.nearbyme.models.VenuesModel
import com.trustathanas.nearbyme.repository.CategoriesRepository

open class CategoriesViewModel(private val repository: CategoriesRepository) : ViewModel() {


    fun getCategories(latitude: String, longitude: String): LiveData<VenuesModel> =
        repository.getCategories(latitude, longitude)

    fun getRequestStatus() = repository.getRequestStatus()
}