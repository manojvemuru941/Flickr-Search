package com.flickr.gallery.ui.flickr

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.flickr.gallery.R
import com.flickr.gallery.databinding.FragmentImageListBinding
import com.flickr.gallery.utils.SEARCH_KEY

/**
 * Created by Manoj Vemuru on 2018-10-20.
 */
open class ListFragment : Fragment() {
    protected lateinit var binding: FragmentImageListBinding
    protected lateinit var viewModel: ListFragmentViewModel
    private var errorSnackbar: Snackbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(arguments != null && arguments?.containsKey(SEARCH_KEY)!!) {

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
        } else {
            loadImages("")
        }
        return binding.root
    }

    /**
     * Loads Images with tag
     * @param query user search text
     */
    protected fun loadImages(query : String) {
        if(query.isBlank()) {
            viewModel.init()
        } else {
            viewModel.init(arguments!!.getString(SEARCH_KEY))
        }
    }

    /**
     * Shows Snack Bar with error message
     * @param errorMessage Error Message
     */
    protected fun showError(@StringRes errorMessage:Int){
        errorSnackbar = Snackbar.make(binding.root, errorMessage, Snackbar.LENGTH_INDEFINITE)
        errorSnackbar?.setAction(R.string.retry, viewModel.errorClickListener)
        errorSnackbar?.show()
    }

    /**
     * Hides Error Message
     */
    protected fun hideError(){
        errorSnackbar?.dismiss()
    }
}
