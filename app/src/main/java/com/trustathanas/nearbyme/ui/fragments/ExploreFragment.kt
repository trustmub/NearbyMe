package com.trustathanas.nearbyme.ui.fragments

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.trustathanas.nearbyme.App
import com.trustathanas.nearbyme.R
import com.trustathanas.nearbyme.ui.adapters.CategoriesAdapter
import com.trustathanas.nearbyme.models.RequestStatus
import com.trustathanas.nearbyme.ui.commons.BaseFragment
import com.trustathanas.nearbyme.viewmodels.CategoriesViewModel
import kotlinx.android.synthetic.main.fragment_explore.*
import kotlinx.android.synthetic.main.fragment_explore.view.*
import org.koin.android.viewmodel.ext.android.viewModel

class ExploreFragment : BaseFragment() {
    override val fragTad: String
        get() = "ExploreFragment"

    override fun getLayout(): Int = R.layout.fragment_explore

    private val categoriesViewModel: CategoriesViewModel by viewModel()

    private lateinit var adapter: CategoriesAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(getLayout(), container, false)

        categoriesViewModel.getRequestStatus().observe(this, Observer {
            it?.let { status ->
                when (status) {
                    RequestStatus.FAILED -> {
                        view.pb_progress_loading.visibility = View.GONE
                        view.rv_categories_list.visibility = View.GONE
                        view.btn_refresh_explore.visibility = View.VISIBLE
                        view.tv_fained_connection_message.visibility = View.VISIBLE
                    }
                    RequestStatus.CONNECTED -> {
                        view.pb_progress_loading.visibility = View.GONE
                        view.rv_categories_list.visibility = View.VISIBLE
                        view.btn_refresh_explore.visibility = View.GONE
                        view.tv_fained_connection_message.visibility = View.GONE
                    }
                    RequestStatus.CONNECTING -> {
                        view.pb_progress_loading.visibility = View.VISIBLE
                        view.rv_categories_list.visibility = View.GONE
                        view.btn_refresh_explore.visibility = View.GONE
                        view.tv_fained_connection_message.visibility = View.GONE

                    }
                }
            }
        })

        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(activity)

        App.locationValue.observe(this, Observer { cordinates ->
            cordinates?.let {
                categoriesViewModel.getCategories(it.latitude.toString(), it.longitude.toString())
                    .observe(activity!!, Observer {
                        adapter = CategoriesAdapter(activity!!, it?.response?.venues!!) {
                            val bundle = Bundle()

//                bundle.putParcelable("VenueItem", VenueParcelable(venueId = it.id, venueName = it.name))
                            bundle.putString("VenueItem", it.id)
                            Navigation.findNavController(view).navigate(R.id.destination_image_list, bundle)
                        }
                        rv_categories_list.let { recyclerView ->
                            recyclerView.adapter = adapter
                            recyclerView.layoutManager = layoutManager
                            recyclerView.setHasFixedSize(true)

                        }
                    })
            }
        })


        view.btn_refresh_explore.setOnClickListener { v ->
            Navigation.findNavController(v).navigate(R.id.destination_explore)
        }
        return view
    }

}