package com.danielmalone.heb.feature

import android.support.v7.widget.RecyclerView
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.danielmalone.heb.feature.PhotosAdapter.ViewHolder
import com.danielmalone.heb.feature.models.Photo
import com.squareup.picasso.Picasso

class PhotosAdapter(val photos: ArrayList<Photo>) : RecyclerView.Adapter<ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        d("daniel", "loading image")
        Picasso.get().load("https://square.github.io/picasso/static/sample.png").into(holder.photo)
        d("daniel", "loaded image")
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
