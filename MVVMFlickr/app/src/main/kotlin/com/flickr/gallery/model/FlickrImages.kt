package com.flickr.gallery.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Manoj Vemuru on 2018-10-20.
 */
class FlickrImages {
    @SerializedName("page")
    @Expose
    var page: Int? = null
    @SerializedName("pages")
    @Expose
    var pages: Int? = null
    @SerializedName("perpage")
    @Expose
    var perpage: Int? = null
    @SerializedName("total")
    @Expose
    var total: Int? = null
    @SerializedName("photo")
    @Expose
    var photo: List<FlickrImage>? = null
}