package com.flickr.gallery.base

import android.arch.lifecycle.ViewModel
import com.flickr.gallery.injection.component.DaggerViewModelInjector
import com.flickr.gallery.injection.component.ViewModelInjector
import com.flickr.gallery.injection.module.DBModule
import com.flickr.gallery.injection.module.NetworkModule
import com.flickr.gallery.ui.flickr.FlickrImageListViewModel
import com.flickr.gallery.ui.flickr.ImageViewModel
import com.flickr.gallery.ui.flickr.base.ListFragmentViewModel
import com.flickr.gallery.ui.flickr.fav.FavListFragmentViewModel

abstract class BaseViewModel:ViewModel(){
    private val injector: ViewModelInjector = DaggerViewModelInjector
            .builder()
            .networkModule(NetworkModule)
            .databaseModule(DBModule)
            .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is FlickrImageListViewModel -> injector.inject(this)
            is ImageViewModel -> injector.inject(this)
            is FavListFragmentViewModel -> injector.inject(this)
            is ListFragmentViewModel -> injector.inject(this)
        }
    }
}