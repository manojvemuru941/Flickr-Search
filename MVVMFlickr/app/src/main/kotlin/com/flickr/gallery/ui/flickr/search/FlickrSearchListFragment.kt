package com.flickr.gallery.ui.flickr.search

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.flickr.gallery.ui.flickr.base.ListFragment
import com.flickr.gallery.utils.SEARCH_KEY

/**
 * Created by Manoj Vemuru on 2018-10-20.
 */

class FlickrSearchListFragment : ListFragment<FlickrSearchListViewModel>() {

    companion object {
        fun newInstanceRecentImagesFragment(searchString: String): FlickrSearchListFragment {
            val fragment = FlickrSearchListFragment()
            val args = Bundle()
            args.putString(SEARCH_KEY, searchString)
            fragment.arguments = args
            return fragment
        }
    }

    override fun loadContent(arguments: Bundle?) {
        if(arguments != null && arguments?.containsKey(SEARCH_KEY)!!) {
            viewModel.init(arguments!!.getString(SEARCH_KEY))
        }
    }

    override fun provideViewModel(): FlickrSearchListViewModel {
     return ViewModelProviders.of(this).get(FlickrSearchListViewModel::class.java)
    }
}