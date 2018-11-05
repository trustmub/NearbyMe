package com.trustathanas.nearbyme.activities

import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.trustathanas.nearbyme.App

abstract class BaseActivity : AppCompatActivity() {

    protected abstract val tag: String
    protected abstract fun getLayout(): Int


    override fun onStart() {
        super.onStart()
        Log.d(tag, "[On Start]")
        App.googleLocation.connect()
    }

    override fun onStop() {
        super.onStop()
        Log.d(tag, "[On Stop]")
        App.googleLocation.disconnect()
    }
}