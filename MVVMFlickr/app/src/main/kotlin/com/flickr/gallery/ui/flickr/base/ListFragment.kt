package com.flickr.gallery.ui.flickr.base

import android.arch.lifecycle.Observer
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.*
import com.flickr.gallery.R
import com.flickr.gallery.databinding.FragmentImageListBinding
import com.flickr.gallery.utils.SORT_TAKEN
import com.flickr.gallery.utils.SORT_UPLOADED

/**
 * Created by Manoj Vemuru on 2018-10-20.
 */
abstract class ListFragment<T : ListFragmentViewModel> : Fragment() {
    protected lateinit var binding: FragmentImageListBinding
    protected lateinit var viewModel: ListFragmentViewModel
    private var errorSnackbar: Snackbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_image_list, container, false)

        binding.postList.layoutManager = GridLayoutManager(activity?.applicationContext, 2)

        viewModel = provideViewModel()
        viewModel.errorMessage.observe(this, Observer {
            errorMessage -> if(errorMessage != null) showError(errorMessage) else hideError()
        })
        binding.viewModel = viewModel

        loadContent(arguments)

        return binding.root
    }

    abstract fun loadContent(arguments: Bundle?)

    abstract fun provideViewModel() : T

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater!!.inflate(R.menu.sort_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.sort_taken -> {
                viewModel.sort(SORT_TAKEN)
            }
            R.id.sort_uploaded -> {
                viewModel.sort(SORT_UPLOADED)
            }
        }
        return true
    }

    /**
     * Shows Snack Bar with error message
     * @param errorMessage Error Message
     */
    open fun showError(@StringRes errorMessage:Int){
        errorSnackbar = Snackbar.make(binding.root, errorMessage, Snackbar.LENGTH_INDEFINITE)
        errorSnackbar?.setAction(R.string.retry, viewModel.errorClickListener)
        errorSnackbar?.show()
    }

    /**
     * Hides Error Message
     */
    open fun hideError(){
        errorSnackbar?.dismiss()
    }
}
