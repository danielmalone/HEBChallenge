package com.danielmalone.heb.feature

import android.support.v7.widget.RecyclerView
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.danielmalone.heb.feature.models.Photo
import com.squareup.picasso.Picasso

class PhotosAdapter(private var photos: List<Photo>) : RecyclerView.Adapter<PhotosAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        d("daniel", "onBindViewHolder(): ${photos[0].id}")
        val url = "https://farm${photos[position].farm}.staticflickr.com/${photos[position].server}/${photos[position].id}_${photos[position].secret}_m.jpg"
        Picasso.get().load(url).into(holder.photo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.photo_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = photos.size

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        val photo: ImageView = itemView!!.findViewById(R.id.photo)
    }
}
