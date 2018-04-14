package com.danielmalone.heb.feature.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Flickr {

    @SerializedName("photos")
    @Expose
    var photos: Photos? = null
    @SerializedName("stat")
    @Expose
    var stat: String? = null

}
