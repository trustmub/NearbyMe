package com.trustathanas.nearbyme.ui.fragments

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.trustathanas.nearbyme.R
import com.trustathanas.nearbyme.ui.adapters.VenuePictureAdapter
import com.trustathanas.nearbyme.ui.commons.BaseFragment
import com.trustathanas.nearbyme.viewmodels.ImagesViewModel
import kotlinx.android.synthetic.main.frgament_image_list_layout.view.*
import org.koin.android.viewmodel.ext.android.viewModel

class ImageListFragment : BaseFragment() {

    override val fragTad: String
        get() = "ImageListFragment"

    override fun getLayout(): Int = R.layout.frgament_image_list_layout

    private val imagesViewModels: ImagesViewModel by viewModel()

    private lateinit var adapter: VenuePictureAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(getLayout(), container, false)

        //TODO make the client id reference the clicked venue. get it from the bundle passed
        val clientId = arguments?.getString("VenueItem")!!

        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(activity, 2)


        imagesViewModels.getVenueImages(clientId).observe(this, Observer {
            it?.let { response ->
                response.response.photos.items.let { itemList ->
                    itemList?.let { pictureItemList ->
                        adapter = VenuePictureAdapter(pictureItemList)

                        view.rv_venue_list_grid.let { rv ->
                            rv.layoutManager = layoutManager
                            rv.setHasFixedSize(true)
                            rv.adapter = adapter
                        }
                    }

                }
            }
        })


        return view
    }

}