package com.flickr.gallery.ui.flickr

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.flickr.gallery.R
import com.flickr.gallery.utils.SEARCH_KEY

/**
 * Created by Manoj Vemuru on 2018-10-20.
 */

class FlickrSearchListFragment : ListFragment() {

    companion object {
        fun newInstanceRecentImagesFragment(searchString: String):FlickrSearchListFragment {
            val fragment = FlickrSearchListFragment()
            val args = Bundle()
            args.putString(SEARCH_KEY, searchString)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_image_list, container, false)

        binding.postList.layoutManager = LinearLayoutManager(activity?.applicationContext, LinearLayoutManager.VERTICAL, false)

        viewModel = ViewModelProviders.of(this).get(ListFragmentViewModel::class.java)
        viewModel.errorMessage.observe(this, Observer {
            errorMessage -> if(errorMessage != null) showError(errorMessage) else hideError()
        })
        binding.viewModel = viewModel

        if(arguments != null && arguments?.containsKey(SEARCH_KEY)!!) {
            loadImages(arguments!!.getString(SEARCH_KEY))
        }
        return binding.root
    }

}