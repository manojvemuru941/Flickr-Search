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
    var primaryId:Int = 0
    @SerializedName("id")
    var id: String? = null
    @SerializedName("url_s")
    var url_s: String? = null
}