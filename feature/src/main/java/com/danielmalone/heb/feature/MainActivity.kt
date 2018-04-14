package com.danielmalone.heb.feature

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import com.danielmalone.heb.feature.models.Photo
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    val NUMBER_OF_COLUMNS = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val photos = arrayListOf<Photo>()
        for (i in 1 until 100) {
            photos.add(Photo("asdf"))
        }

        recyclerView.apply {
            layoutManager = GridLayoutManager(this@MainActivity, NUMBER_OF_COLUMNS)
            adapter = PhotosAdapter(photos)
        }
    }
}
