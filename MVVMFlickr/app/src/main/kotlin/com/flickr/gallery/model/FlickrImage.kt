package com.flickr.gallery.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.flickr.gallery.utils.DATE_FORMATTER
import com.google.gson.annotations.SerializedName

/**
 * Created by Manoj Vemuru on 2018-10-19.
 */
@Entity
class FlickrImage : Comparable<FlickrImage> {
    @PrimaryKey(autoGenerate = true)
    var primaryId:Int = 0
    @SerializedName("id")
    var id: String? = null
    @SerializedName("url_s")
    var url_s: String? = null
    @SerializedName("dateupload")
    var dateupload:String? = null
    @SerializedName("datetaken")
    var datetaken : String? = null
    @SerializedName("ownername")
    var ownername : String? = null
}