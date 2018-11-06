package com.trustathanas.nearbyme.utilities

import android.content.Context

class SharedPreferencesMain(context: Context) {

    private val PREF_FILE = "AppPreferences"
    private val preferences = context.getSharedPreferences(PREF_FILE, 0)

    private val LATITUDE = "latitude"
    private val LONGITUDE = "longitude"

    var latitude: String?
        get() = preferences.getString(LATITUDE, "37.7")
        set(value) = preferences.edit().putString(LATITUDE, value).apply()

    var longitude: String?
        get() = preferences.getString(LONGITUDE, "-122.4")
        set(value) = preferences.edit().putString(LONGITUDE, value).apply()
}