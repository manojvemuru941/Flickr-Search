package com.flickr.gallery.model.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.flickr.gallery.model.FavImageDao
import com.flickr.gallery.model.FlickrImage

@Database(entities = [FlickrImage::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favImageDao(): FavImageDao
}