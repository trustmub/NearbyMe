package com.trustathanas.nearbyme.fragments

import com.trustathanas.nearbyme.R

class ImageFragment: BaseFragment() {
    override val fragTad: String
        get() = "ImagesFragment"

    override fun getLayout(): Int = R.layout.fragment_image_layout
}