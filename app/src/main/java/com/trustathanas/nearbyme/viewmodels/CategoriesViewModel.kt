package com.trustathanas.nearbyme.viewmodels

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.trustathanas.nearbyme.models.VenuesModel
import com.trustathanas.nearbyme.repository.CategoriesRepository

open class CategoriesViewModel(private val repository: CategoriesRepository) : ViewModel() {

    private var categories: LiveData<VenuesModel> = MutableLiveData()

    fun getCategories(latitude: String, longitude: String): LiveData<VenuesModel> {
        categories = repository.getCategories(latitude, longitude)
        return categories
    }

    fun getRequestStatus() = repository.getRequestStatus()
}