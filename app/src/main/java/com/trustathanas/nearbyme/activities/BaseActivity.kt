package com.trustathanas.nearbyme.activities

import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.trustathanas.nearbyme.utilities.GoogleLocation
import org.koin.android.ext.android.inject

abstract class BaseActivity : AppCompatActivity() {

    protected abstract val tag: String
    protected abstract fun getLayout(): Int
    val googlelocation: GoogleLocation by inject()


    override fun onStart() {
        super.onStart()
        Log.d(tag, "[On Start]")
        googlelocation.getInstance(this).connect()
    }

    override fun onStop() {
        super.onStop()
        Log.d(tag, "[On Stop]")
        googlelocation.getInstance(this).disconnect()

    }

}