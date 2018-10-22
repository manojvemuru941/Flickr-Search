package com.flickr.gallery.ui.flickr.search

import android.os.Bundle
import com.flickr.gallery.ui.flickr.base.ListFragment
import com.flickr.gallery.utils.SEARCH_KEY
import com.flickr.gallery.utils.VIEW_KEY

/**
 * Created by Manoj Vemuru on 2018-10-20.
 */

class FlickrSearchListFragment : ListFragment() {

    companion object {
        fun newInstanceRecentImagesFragment(searchString: String): FlickrSearchListFragment {
            val fragment = FlickrSearchListFragment()
            val args = Bundle()
            args.putString(SEARCH_KEY, searchString)
            args.putInt(VIEW_KEY, VIEW_TYPE.SEARCH.type)
            fragment.arguments = args
            return fragment
        }
    }
}