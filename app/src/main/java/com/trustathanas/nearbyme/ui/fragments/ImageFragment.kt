package com.trustathanas.nearbyme.ui.fragments

import com.trustathanas.nearbyme.R
import com.trustathanas.nearbyme.ui.commons.BaseFragment

class ImageFragment: BaseFragment() {
    override val fragTad: String
        get() = "ImagesFragment"

    override fun getLayout(): Int = R.layout.fragment_image_layout
}