package com.flickr.gallery.model

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface FavImageDao {
    @get:Query("SELECT * FROM flickrimage")
    val all: List<FlickrImage>

    @Insert
    fun insertFavImage(vararg favImage: FlickrImage)
}