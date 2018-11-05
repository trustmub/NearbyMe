package com.trustathanas.nearbyme.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.trustathanas.nearbyme.models.RequestStatus
import com.trustathanas.nearbyme.models.VenuesModel
import com.trustathanas.nearbyme.utilities.FOURSQUARE_CLIENT_ID
import com.trustathanas.nearbyme.utilities.FOURSQUARE_CLIENT_SECRET
import com.trustathanas.nearbyme.utilities.GoogleLocation
import com.trustathanas.nearbyme.utilities.SharedPreferencesMain
import com.trustathanas.nearbyme.webservices.WebserviceInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoriesRepository constructor(
    private val webservices: WebserviceInterface,
    private val sharedPreferencesMain: SharedPreferencesMain
) {

    private val requestResult: MutableLiveData<RequestStatus> = MutableLiveData()


    fun getRequestStatus(): LiveData<RequestStatus> = requestResult

    fun getCategories(): LiveData<VenuesModel> {
        requestResult.value = RequestStatus.CONNECTING
        val results: MutableLiveData<VenuesModel> = MutableLiveData()
        val latitude = -25.9 //sharedPreferencesMain . latitude //-25.9
        val longitude = 28.1 // sharedPreferencesMain . longitude // 28.1
        webservices.getCategories(
            ll = "${latitude.toString()},${longitude.toString()}"
        ).enqueue(CategoriesCallBack(results))
        return results
    }

    inner class CategoriesCallBack(val results: MutableLiveData<VenuesModel>) : Callback<VenuesModel> {

        override fun onFailure(call: Call<VenuesModel>, t: Throwable) {
            requestResult.value = RequestStatus.FAILED

        }

        override fun onResponse(call: Call<VenuesModel>, response: Response<VenuesModel>) {
            println("In Result ${results.value}")
            println("In Result ${response.code()}")
            requestResult.value = RequestStatus.CONNECTED

            results.value = when {
                response.isSuccessful -> {
                    println("In Response Body ${response.body()}")
                    response.body()
                }
                response.code().equals(400) -> {
                    println("${response.body()}")
                    response.body()
                }
                else -> response.body()
            }

        }


    }
}