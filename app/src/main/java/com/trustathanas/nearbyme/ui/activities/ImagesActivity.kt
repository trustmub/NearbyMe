package com.trustathanas.nearbyme.ui.activities

import com.trustathanas.nearbyme.R
import com.trustathanas.nearbyme.ui.commons.BaseActivity

class ImagesActivity: BaseActivity() {
    override val tag: String
        get() = "ImagesActivity"

    override fun getLayout(): Int = R.layout.activity_images
}