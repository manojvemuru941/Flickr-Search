package com.flickr.gallery.ui.flickr.recent

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.flickr.gallery.ui.flickr.base.ListFragment

/**
 * Created by Manoj Vemuru on 2018-10-20.
 */

class FlickrRecentListFragment : ListFragment<FlickrRecentListViewModel>() {

    companion object {
        fun newInstanceRecentImagesFragment(): FlickrRecentListFragment {
            return FlickrRecentListFragment()
        }
    }

    override fun loadContent(arguments: Bundle?) {
        viewModel.init()
    }

    override fun provideViewModel(): FlickrRecentListViewModel {
     return ViewModelProviders.of(this).get(FlickrRecentListViewModel::class.java)
    }
}