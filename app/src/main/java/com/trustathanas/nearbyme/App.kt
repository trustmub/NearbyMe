package com.trustathanas.nearbyme

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import com.trustathanas.nearbyme.models.LocationModel
import com.trustathanas.nearbyme.repository.CategoriesRepository
import com.trustathanas.nearbyme.repository.ImagesRepository
import com.trustathanas.nearbyme.utilities.BASE_URL
import com.trustathanas.nearbyme.utilities.GoogleLocation
import com.trustathanas.nearbyme.utilities.SharedPreferencesMain
import com.trustathanas.nearbyme.viewmodels.CategoriesViewModel
import com.trustathanas.nearbyme.viewmodels.ImagesViewModel
import com.trustathanas.nearbyme.data.network.RetrofitInterceptor
import com.trustathanas.nearbyme.data.network.WebserviceInterface
import com.trustathanas.nearbyme.repository.LocationRepository
import com.trustathanas.nearbyme.viewmodels.LocationViewModel
import org.koin.android.ext.android.startKoin
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.Module
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App : Application() {

    companion object {
        //        lateinit var appContext: Context
        //  lateinit var googleLocation: GoogleApiClient
        var locationValue: MutableLiveData<LocationModel> = MutableLiveData()
    }


    override fun onCreate() {
        super.onCreate()
        initializeApplication()
    }

    private fun initializeApplication() {
//        appContext = applicationContext

        startKoin(
            this,
            listOf(getGeneralModules, getStorageModule, getNetworkModules, getRepositoryModules, getViewModelModules)
        )
    }

    val getGeneralModules = module {
        single(name = "context") { applicationContext }
    }

    val getStorageModule: Module = module {
        single { SharedPreferencesMain(get("context")) }

    }
    val getNetworkModules = module {
        single { GoogleLocation(get(), get("context")) }
        single { get<Retrofit>().create<WebserviceInterface>(WebserviceInterface::class.java) }
        single { RetrofitInterceptor }
        single {
            Retrofit.Builder()
                .client(RetrofitInterceptor()!!)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }

    val getRepositoryModules = module {
        single { CategoriesRepository(get(), get()) }
        single { ImagesRepository(get()) }
        single { LocationRepository(get()) }
    }

    val getViewModelModules = module {
        viewModel { CategoriesViewModel(get()) }
        viewModel { ImagesViewModel(get()) }
        viewModel { LocationViewModel(get()) }
    }

}