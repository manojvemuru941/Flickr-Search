package com.flickr.gallery.ui.flickr.recent

import com.flickr.gallery.BuildConfig
import com.flickr.gallery.ui.flickr.base.ListFragment
import com.flickr.gallery.ui.flickr.base.ListFragmentViewModel
import com.flickr.gallery.utils.*

/**
 * Created by Manoj Vemuru on 2018-10-24.
 */
class FlickrRecentListViewModel : ListFragmentViewModel() {

    override fun loadImages() {
        handleResponse(flickrApi.getFlickrLatestImages(METHOD_NAME_RECENT, BuildConfig.FLICKR_API_TOKEN, FORMAT, NO_JSON_CALL_BACK, EXTRAS))
    }
}