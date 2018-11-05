package com.trustathanas.nearbyme.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.squareup.picasso.Picasso
import com.trustathanas.nearbyme.R
import com.trustathanas.nearbyme.models.PictureItemsItem

class VenuePictureAdapter(private val picturePhoto: List<PictureItemsItem>) :
    RecyclerView.Adapter<VenuePictureAdapter.VenuePictureViewHolder>() {

    lateinit var imageURL: String
    var imageWidth: Int = 300
    var imageHeight: Int = 500


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VenuePictureViewHolder {
        val venueView = LayoutInflater.from(parent.context).inflate(R.layout.venue_picture_item_layout, parent, false)
        return VenuePictureViewHolder(venueView)
    }

    override fun getItemCount(): Int {
        return picturePhoto.size
    }

    override fun onBindViewHolder(holder: VenuePictureViewHolder, position: Int) {
        holder.bindHolder(picturePhoto[position])
    }

    inner class VenuePictureViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView = itemView.findViewById<ImageView>(R.id.iv_venue_item_image)

        fun bindHolder(pictureItem: PictureItemsItem) {
            imageURL = "${pictureItem.prefix}${imageWidth}x$imageHeight${pictureItem.suffix}"

            Picasso.get()
                .load(imageURL)
                .placeholder(R.drawable.ic_error_outline_black_24dp)
                .resize(imageWidth, imageHeight)
                .into(imageView)
        }

    }
}