package com.trustathanas.nearbyme.ui.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.trustathanas.nearbyme.R
import com.trustathanas.nearbyme.models.VenuesItem
import kotlinx.android.synthetic.main.venue_item_layout.view.*

class CategoriesAdapter(
    private val context: Context,
    private val venuesCategoryList: List<VenuesItem>,
    private val itemClick: (VenuesItem) -> Unit
) :
    RecyclerView.Adapter<CategoriesAdapter.CategoryViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.venue_item_layout, parent, false)
        return CategoryViewHolder(view, itemClick)
    }

    override fun getItemCount(): Int {
        return venuesCategoryList.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bindVenueCategory(venuesCategoryList[position])

    }

    inner class CategoryViewHolder(itemView: View, itemClick: (VenuesItem) -> Unit) : RecyclerView.ViewHolder(itemView) {

        fun bindVenueCategory(category: VenuesItem) {
            itemView.tv_venue_name.text = category.name
            itemView.tv_venue_country.text = category.location.country

            itemView.setOnClickListener { itemClick(category) }


        }
    }
}
