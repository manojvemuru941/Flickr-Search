package com.flickr.gallery.ui.flickr.recent

import com.flickr.gallery.ui.flickr.base.ListFragment

/**
 * Created by Manoj Vemuru on 2018-10-20.
 */

class FlickrRecentListFragment : ListFragment() {

    companion object {
        fun newInstanceRecentImagesFragment(): FlickrRecentListFragment {
            return FlickrRecentListFragment()
        }
    }
}