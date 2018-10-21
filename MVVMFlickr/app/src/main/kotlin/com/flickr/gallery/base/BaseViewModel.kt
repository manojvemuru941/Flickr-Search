package com.flickr.gallery.base

import android.arch.lifecycle.ViewModel
import com.flickr.gallery.injection.component.DaggerViewModelInjector
import com.flickr.gallery.injection.component.ViewModelInjector
import com.flickr.gallery.injection.module.NetworkModule
import com.flickr.gallery.ui.flickr.FlickrImageListViewModel
import com.flickr.gallery.ui.flickr.ListFragmentViewModel
import com.flickr.gallery.ui.flickr.ImageViewModel

abstract class BaseViewModel:ViewModel(){
    private val injector: ViewModelInjector = DaggerViewModelInjector
            .builder()
            .networkModule(NetworkModule)
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
            is ListFragmentViewModel -> injector.inject(this)
        }
    }
}