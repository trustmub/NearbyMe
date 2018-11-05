package com.trustathanas.nearbyme.fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log

abstract class BaseFragment : Fragment() {

    protected abstract val fragTad: String
    protected abstract fun getLayout(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(fragTad, "[OnCreate]")
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        Log.d(fragTad, "[OnAttach]")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(fragTad, "[OnDetach")
    }

}