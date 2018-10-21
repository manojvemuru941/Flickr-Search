package com.flickr.gallery.injection.component

import dagger.Component
import com.flickr.gallery.injection.module.NetworkModule
import com.flickr.gallery.ui.flickr.FlickrImageListViewModel
import com.flickr.gallery.ui.flickr.ListFragmentViewModel
import com.flickr.gallery.ui.flickr.ImageViewModel
import javax.inject.Singleton

/**
 * Component providing inject() methods for presenters.
 */
@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {
    /**
     * Injects required dependencies into the specified FlickrImageListViewModel.
     * @param flickrImageListViewModel FlickrImageListViewModel in which to inject the dependencies
     */
    fun inject(flickrImageListViewModel: FlickrImageListViewModel)

    fun inject(recentFragmentViewModel: ListFragmentViewModel)

    /**
     * Injects required dependencies into the specified ImageViewModel.
     * @param imageViewModel ImageViewModel in which to inject the dependencies
     */
    fun inject(imageViewModel: ImageViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}