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

/**
 * Created by Manoj Vemuru on 2018-10-20.
 */

class FlickrRecentListFragment : ListFragment() {

    companion object {
        fun newInstanceRecentImagesFragment():FlickrRecentListFragment {
            return  FlickrRecentListFragment()
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
        loadImages("")
        return binding.root
    }
}