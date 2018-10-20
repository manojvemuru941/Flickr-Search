package com.flickr.gallery.injection

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.persistence.room.Room
import android.support.v7.app.AppCompatActivity
import com.flickr.gallery.model.database.AppDatabase
import com.flickr.gallery.ui.flickr.FlickrImageListViewModel

class ViewModelFactory(private val activity: AppCompatActivity): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FlickrImageListViewModel::class.java)) {
            val db = Room.databaseBuilder(activity.applicationContext, AppDatabase::class.java, "favs").build()
            @Suppress("UNCHECKED_CAST")
            return FlickrImageListViewModel(db.favImageDao()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}