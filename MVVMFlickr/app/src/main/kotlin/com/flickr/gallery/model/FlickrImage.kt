package com.flickr.gallery.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Manoj Vemuru on 2018-10-19.
 */
@Entity
class FlickrImage {
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0

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