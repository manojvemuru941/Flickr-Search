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
    @SerializedName("id")
    private var id: String? = null
    @SerializedName("url_s")
    private var imageUrl: String? = null


    fun setId(id: String) {
        this.id = id
    }

    fun setImageUrl(imageUrl: String) {
        this.imageUrl = imageUrl
    }

    fun getId(): String? {
        return id
    }

    fun getImageUrl(): String? {
        return imageUrl
    }
}