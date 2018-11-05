package com.trustathanas.nearbyme.viewmodels

import android.arch.lifecycle.ViewModel
import com.trustathanas.nearbyme.repository.CategoriesRepository

open class CategoriesViewModel(private val repository: CategoriesRepository) : ViewModel() {

    fun getCategories() = repository.getCategories()

    fun getRequestStatus() = repository.getRequestStatus()
}