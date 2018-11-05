package com.trustathanas.nearbyme.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.trustathanas.nearbyme.models.RequestStatus
import com.trustathanas.nearbyme.models.VenuePictureResponse
import com.trustathanas.nearbyme.webservices.WebserviceInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ImagesRepository(val webserviceInterface: WebserviceInterface) {

    private val requestResult: MutableLiveData<RequestStatus> = MutableLiveData()


    fun getVenueImages(venue_id: String): LiveData<VenuePictureResponse> {

        requestResult.value = RequestStatus.CONNECTING

        val results: MutableLiveData<VenuePictureResponse> = MutableLiveData()
        webserviceInterface.getVenueImages(venue_id).enqueue(VenueImageCallBack(results))
        return results
    }

    inner class VenueImageCallBack(val results: MutableLiveData<VenuePictureResponse>) :
        Callback<VenuePictureResponse> {
        override fun onFailure(call: Call<VenuePictureResponse>, t: Throwable) {
            requestResult.value = RequestStatus.FAILED
        }

        override fun onResponse(call: Call<VenuePictureResponse>, response: Response<VenuePictureResponse>) {
            requestResult.value = RequestStatus.CONNECTED
            results.value = when {
                response.isSuccessful -> response.body()
                else -> response.body()
            }
        }
    }
}