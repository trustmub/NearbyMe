package com.trustathanas.nearbyme.webservices

import com.trustathanas.nearbyme.models.VenuePictureResponse
import com.trustathanas.nearbyme.models.VenuesModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WebserviceInterface {

    // https://api.foursquare.com/v2/venues/search?ll=-25.9,28.1&client_id=&client_secret=&v=20181101
    @GET("venues/search")
    fun getCategories(
        @Query("ll") ll: String
    ): Call<VenuesModel>

    //    https://api.foursquare.com/v2/venues/VENUE_ID/photos
    @GET("venues/{VENUE_ID}/photos")
    fun getVenueImages(
        @Path("VENUE_ID") venue_id: String): Call<VenuePictureResponse>

    //    https://fastly.4sqi.net/img/general/300x500/8267782_GaFL6AICcm0wsho2O9QFa1H7e-xwBsxpN-fKm838hHI.jpg
    fun getSingleImage() {}
}
