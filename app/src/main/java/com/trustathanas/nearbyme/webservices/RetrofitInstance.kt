package com.trustathanas.nearbyme.webservices


import com.squareup.okhttp.OkHttpClient
import com.squareup.okhttp.logging.HttpLoggingInterceptor
import com.trustathanas.nearbyme.utilities.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private var instance: Retrofit? = null


//    private fun logging(): HttpLoggingInterceptor {
//        val log = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
//        return OkHttpClient.Builder().addNetworkInterceptor {  } addInterceptor(log)
//    }


    fun getApiInstance(): Retrofit? {
        if (instance == null) {
            synchronized(this) {
                if (instance == null) {
                    instance = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                }
            }
        }
        return instance
    }

}
