package com.danielmalone.heb.feature

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import com.danielmalone.heb.feature.models.Photo
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        setupObservers()

        swipeRefreshLayout.setOnRefreshListener {
            // I really don't like this pattern (going directly to source). But it works.
            PhotoRepository().getPhotos().observe(this@MainActivity, Observer {
                if (it != null) {
                    updateRecyclerView(it)
                }
            })
            swipeRefreshLayout.isRefreshing = false
        }
    }

    private fun setupObservers() {
        mainViewModel.photosObservable.observe(this, Observer {
            if (it != null) {
                updateRecyclerView(it)
            }
        })
    }

    private fun updateRecyclerView(photos: List<Photo>) {
        recyclerView.apply {
            layoutManager = GridLayoutManager(this@MainActivity, resources.getInteger(R.integer.number_of_columns))
            adapter = PhotosAdapter(photos)
        }
    }
}
