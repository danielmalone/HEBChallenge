package com.danielmalone.heb.feature.utilities

class UrlFormatter {

    companion object {

        const val FLICKR_BASE_URL = "https://api.flickr.com/services/rest/"
        const val FLICKR_API_METHOD = "flickr.photos.getRecent"
        const val FLICKR_API_KEY = "3d99afcbd3cf85e827a7ad1da8dab431"
        const val FLICKR_FORMAT = "json"
        const val FLICKR_ADDITIONAL_PARAMATERS = "&extras=tags%3Dcar&nojsoncallback=1"
        const val FLICKR_PHOTOS_PER_PAGE = 2
        const val FLICKR_CURRENT_PAGE = 1
    }

    fun getUrl(): String {
        return "$FLICKR_BASE_URL?method=$FLICKR_API_METHOD&api_key=$FLICKR_API_KEY&format=$FLICKR_FORMAT&$FLICKR_ADDITIONAL_PARAMATERS&per_page=$FLICKR_PHOTOS_PER_PAGE&page=$FLICKR_CURRENT_PAGE"
    }
}