package com.flickr.gallery.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Manoj Vemuru on 2018-10-19.
 */

class FlickrResponse {
    @SerializedName("photos")
    @Expose
    private var images: FlickrImages? = null
    @SerializedName("stat")
    @Expose
    private var stat: String? = null

    fun getImages(): FlickrImages? {
        return images
    }

    fun setImages(images: FlickrImages) {
        this.images = images
    }

    fun getStat(): String? {
        return stat
    }

    fun setStat(stat: String) {
        this.stat = stat
    }
}