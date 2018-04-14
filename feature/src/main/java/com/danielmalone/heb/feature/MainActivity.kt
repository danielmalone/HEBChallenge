package com.danielmalone.heb.feature

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.util.Log.d
import com.danielmalone.heb.feature.models.Flickr
import com.danielmalone.heb.feature.models.Photo
import com.danielmalone.heb.feature.models.Photos
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.net.URL

class MainActivity : AppCompatActivity() {

    val NUMBER_OF_COLUMNS = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {
            fetchData()
        }

        fetchData()
    }

    private fun fetchData() {
        doAsync {
            val uri = URL("https://api.flickr.com/services/rest/?method=flickr.photos.getRecent&api_key=3d99afcbd3cf85e827a7ad1da8dab431&format=json")
            val json = uri.readText().replace("jsonFlickrApi(", "").replace("})", "}")
            d("daniel", " json? $json")
            val photos = Gson().fromJson(json, Flickr::class.java)
            d("daniel", "photos? $photos")
            uiThread {
                if (photos != null) {
                    photos.photos?.photo
                    updateRecyclerView(photos.photos!!.photo!!)
                }
            }
        }
    }

    private fun updateRecyclerView(photos: List<Photo>) {
        recyclerView.apply {
            layoutManager = GridLayoutManager(this@MainActivity, NUMBER_OF_COLUMNS)
            adapter = PhotosAdapter(photos)
        }
    }
}
