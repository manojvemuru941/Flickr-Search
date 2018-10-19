package com.flicker.image.gallery.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Manoj Vemuru on 2018-10-19.
 */
class FlickrResponse {
    @SerializedName("items")
    var imagesList:List<FlickrImage>? = null
}