package com.danielmalone.heb.feature

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import com.danielmalone.heb.feature.models.Photo

class MainViewModel : ViewModel() {

    val photos: MutableLiveData<List<Photo>> = MutableLiveData()
    var photosObservable = Transformations.switchMap(PhotoRepository().getPhotos()) { photoRepository ->
        photos.value = photoRepository
        return@switchMap photos
    }
}