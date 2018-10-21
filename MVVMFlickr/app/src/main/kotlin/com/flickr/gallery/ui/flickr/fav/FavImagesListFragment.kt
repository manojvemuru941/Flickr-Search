package com.flickr.gallery.ui.flickr.fav

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.flickr.gallery.R
import com.flickr.gallery.ui.flickr.base.ListFragment
import com.flickr.gallery.ui.flickr.base.ListFragmentViewModel
import com.flickr.gallery.utils.SEARCH_KEY

/**
 * Created by Manoj Vemuru on 2018-10-21.
 */
class FavImagesListFragment : ListFragment() {
    companion object {
        fun newInstanceRecentImagesFragment(): FavImagesListFragment {
            return FavImagesListFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_image_list, container, false)

        binding.postList.layoutManager = GridLayoutManager(activity?.applicationContext, 2)

        viewModel = ViewModelProviders.of(this).get(FavListFragmentViewModel::class.java)
        viewModel.errorMessage.observe(this, Observer {
            errorMessage -> if(errorMessage != null) showError(errorMessage) else hideError()
        })
        binding.viewModel = viewModel

        return binding.root
    }
}