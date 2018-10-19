package com.flicker.image.gallery.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Manoj Vemuru on 2018-10-19.
 */

class FlickrImage() {
    @SerializedName("title")
    @Expose
    var title: String? = null

    @SerializedName("link")
    @Expose
    var imageURL: String? = null

    @SerializedName("date_taken")
    @Expose
    var dateTaken: String? = null

    @SerializedName("description")
    @Expose
    var description: String? = null

    @SerializedName("author")
    @Expose
    var author: String? = null
}