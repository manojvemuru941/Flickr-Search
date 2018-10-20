package com.flickr.gallery.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Manoj Vemuru on 2018-10-19.
 */

class FlickrResponse {
    @SerializedName("title")
    var title:String? =null

    @SerializedName("link")
    var link:String? = null

    @SerializedName("items")
    var items:List<FlickrImage>? = null
}