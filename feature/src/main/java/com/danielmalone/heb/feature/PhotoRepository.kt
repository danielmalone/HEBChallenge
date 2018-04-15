package com.danielmalone.heb.feature

import android.arch.lifecycle.MutableLiveData
import com.danielmalone.heb.feature.models.Flickr
import com.danielmalone.heb.feature.models.Photo
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import java.net.URL

class PhotoRepository {

    fun getPhotos(): MutableLiveData<List<Photo>> {
        val photosObservable: MutableLiveData<List<Photo>> = MutableLiveData()

        doAsync {
            val uri = URL("https://api.flickr.com/services/rest/?method=flickr.photos.getRecent&api_key=3d99afcbd3cf85e827a7ad1da8dab431&format=json&extras=tags%3Dcar&nojsoncallback=1")
            val json = uri.readText()
            val photos = Gson().fromJson(json, Flickr::class.java)
            photosObservable.postValue(photos.photos!!.photo)
        }
        return photosObservable
    }
}