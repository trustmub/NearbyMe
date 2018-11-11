package com.trustathanas.nearbyme.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.trustathanas.nearbyme.R
import com.trustathanas.nearbyme.ui.commons.BaseFragment

class MoreFragment : BaseFragment() {
    override val fragTad: String
        get() = "MoreFragment"

    override fun getLayout(): Int = R.layout.fragment_more

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(getLayout(), container, false)
        return view
    }
}