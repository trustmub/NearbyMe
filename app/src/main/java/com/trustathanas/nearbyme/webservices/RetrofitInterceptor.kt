package com.trustathanas.nearbyme.webservices

import com.trustathanas.nearbyme.utilities.FOURSQUARE_CLIENT_ID
import com.trustathanas.nearbyme.utilities.FOURSQUARE_CLIENT_SECRET
import okhttp3.Interceptor
import okhttp3.OkHttpClient

object RetrofitInterceptor {

    operator fun invoke(): OkHttpClient? {
        val requestInterceptor = Interceptor { chain ->

            /**
             * interception will only be done on endpoints which require authentication.
             */
            if (chain.request().header("No-Authentication") == null) {
                val url = chain.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("client_id", FOURSQUARE_CLIENT_ID)
                    .addQueryParameter("client_secret", FOURSQUARE_CLIENT_SECRET)
                    .addQueryParameter("v", "20181101")
                    .build()
                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()
                println("In Interceptor ${request}")

                return@Interceptor chain.proceed(request)
            }
            return@Interceptor chain.proceed(chain.request())
        }

        return OkHttpClient.Builder().addInterceptor(requestInterceptor).build()
    }
}
