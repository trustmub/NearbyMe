package com.trustathanas.nearbyme

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import android.content.SharedPreferences
import com.google.android.gms.common.api.GoogleApiClient
import com.trustathanas.nearbyme.models.LocationModel
import com.trustathanas.nearbyme.repository.CategoriesRepository
import com.trustathanas.nearbyme.repository.ImagesRepository
import com.trustathanas.nearbyme.utilities.BASE_URL
import com.trustathanas.nearbyme.utilities.GoogleLocation
import com.trustathanas.nearbyme.utilities.SharedPreferencesMain
import com.trustathanas.nearbyme.viewmodels.CategoriesViewModel
import com.trustathanas.nearbyme.viewmodels.ImagesViewModel
import com.trustathanas.nearbyme.webservices.RetrofitInterceptor
import com.trustathanas.nearbyme.webservices.WebserviceInterface
import org.koin.android.ext.android.startKoin
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.sin

class App : Application() {

    companion object {
        lateinit var appContext: Context
        lateinit var googleLocation: GoogleApiClient
        //        val webService = RetrofitInstance.getApiInstance()!!.create(WebserviceInterface::class.java)
        var locationValue: MutableLiveData<LocationModel> = MutableLiveData()
    }


    override fun onCreate() {
        super.onCreate()
        initializeApplication()
    }

    private fun initializeApplication() {
        appContext = applicationContext
        googleLocation = GoogleLocation.getInstance(appContext)
        startKoin(this, listOf(utilitiesModules, RepositoryModules, viewModelModules))
    }

    val utilitiesModules = module {
        single { SharedPreferencesMain(appContext) }
        single { get<Retrofit>().create<WebserviceInterface>(WebserviceInterface::class.java) }
        single { RetrofitInterceptor }
        single {
            Retrofit.Builder()
                .client(RetrofitInterceptor.invoke()!!)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }

    val RepositoryModules = module {
        single { CategoriesRepository(get(), get()) }
        single { ImagesRepository(get()) }
    }

    val viewModelModules = module {
        viewModel { CategoriesViewModel(get()) }
        viewModel { ImagesViewModel(get()) }
    }

}