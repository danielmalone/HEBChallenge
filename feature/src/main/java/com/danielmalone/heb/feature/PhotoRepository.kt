package com.danielmalone.heb.feature

import android.arch.lifecycle.MutableLiveData
import com.danielmalone.heb.feature.models.Flickr
import com.danielmalone.heb.feature.models.Photo
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import java.net.URL

class PhotoRepository {

    fun getPhotos(): MutableLiveData<List<Photo>> {
        val something: MutableLiveData<List<Photo>> = MutableLiveData()

        doAsync {
            val uri = URL("https://api.flickr.com/services/rest/?method=flickr.photos.getRecent&api_key=3d99afcbd3cf85e827a7ad1da8dab431&format=json")
            val json = uri.readText().replace("jsonFlickrApi(", "").replace("})", "}")
            val photos = Gson().fromJson(json, Flickr::class.java)
            something.postValue(photos.photos!!.photo)
        }
        return something
    }
}