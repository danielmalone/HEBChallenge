package com.danielmalone.heb.feature

import android.arch.lifecycle.MutableLiveData
import com.danielmalone.heb.feature.models.Flickr
import com.danielmalone.heb.feature.models.Photo
import com.danielmalone.heb.feature.utilities.UrlFormatter
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import java.net.URL

class PhotoRepository {

    fun getPhotos(): MutableLiveData<ArrayList<Photo>> {
        val photosObservable: MutableLiveData<ArrayList<Photo>> = MutableLiveData()

        doAsync {

            val url = URL(UrlFormatter().getUrl())
            val json = url.readText() // todo: use OkHttp
            val photos = Gson().fromJson(json, Flickr::class.java)
            photosObservable.postValue(photos.photos!!.photo)
        }
        return photosObservable
    }
}