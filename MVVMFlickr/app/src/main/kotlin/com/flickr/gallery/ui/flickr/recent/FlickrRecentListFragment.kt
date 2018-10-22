package com.flickr.gallery.ui.flickr.recent

import android.os.Bundle
import com.flickr.gallery.ui.flickr.base.ListFragment
import com.flickr.gallery.ui.flickr.search.FlickrSearchListFragment
import com.flickr.gallery.utils.SEARCH_KEY
import com.flickr.gallery.utils.VIEW_KEY

/**
 * Created by Manoj Vemuru on 2018-10-20.
 */

class FlickrRecentListFragment : ListFragment() {

    companion object {
        fun newInstanceRecentImagesFragment(): FlickrRecentListFragment {
            val fragment = FlickrRecentListFragment()
            val args = Bundle()
            args.putInt(VIEW_KEY, VIEW_TYPE.RECENT.type)
            fragment.arguments = args
            return fragment
        }
    }
}