package com.flickr.gallery.ui.flickr.fav

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.flickr.gallery.ui.flickr.base.ListFragment

/**
 * Created by Manoj Vemuru on 2018-10-21.
 */
class FavImagesListFragment : ListFragment<FavListFragmentViewModel>() {

    companion object {
        fun newInstanceRecentImagesFragment(): FavImagesListFragment {
            return FavImagesListFragment()
        }
    }

    override fun loadContent(arguments: Bundle?) {

    }

    override fun provideViewModel(): FavListFragmentViewModel {
       return ViewModelProviders.of(this).get(FavListFragmentViewModel::class.java)
    }
}