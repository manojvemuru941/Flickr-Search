package com.flickr.gallery.ui.flickr.search

import com.flickr.gallery.BuildConfig
import com.flickr.gallery.ui.flickr.base.ListFragmentViewModel
import com.flickr.gallery.utils.EXTRAS
import com.flickr.gallery.utils.FORMAT
import com.flickr.gallery.utils.METHOD_NAME_SEARCH
import com.flickr.gallery.utils.NO_JSON_CALL_BACK

/**
 * Created by Manoj Vemuru on 2018-10-24.
 */

class FlickrSearchListViewModel : ListFragmentViewModel() {

    override fun loadImages() {
        handleResponse(flickrApi.getSearchImages(METHOD_NAME_SEARCH, BuildConfig.FLICKR_API_TOKEN, FORMAT, NO_JSON_CALL_BACK, EXTRAS, searchQuery))
    }
}