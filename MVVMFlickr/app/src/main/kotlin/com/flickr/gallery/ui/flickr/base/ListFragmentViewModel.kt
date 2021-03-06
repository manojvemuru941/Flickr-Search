package com.flickr.gallery.ui.flickr.base

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import android.view.View
import com.flickr.gallery.R
import com.flickr.gallery.base.BaseViewModel
import com.flickr.gallery.model.FlickrImage
import com.flickr.gallery.model.FlickrResponse
import com.flickr.gallery.network.FlickrApi
import com.flickr.gallery.ui.flickr.adapters.FlickrImageListAdapter
import com.flickr.gallery.utils.DATE_FORMATTER
import com.flickr.gallery.utils.SORT_TAKEN
import com.flickr.gallery.utils.SORT_UPLOADED
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.*
import javax.inject.Inject

/**
 * Created by Manoj Vemuru on 2018-10-20.
 */

open class ListFragmentViewModel : BaseViewModel() {
    @Inject
    lateinit var flickrApi: FlickrApi

    val imageListAdapter: FlickrImageListAdapter = FlickrImageListAdapter()

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage: MutableLiveData<Int> = MutableLiveData()
    open val errorClickListener = View.OnClickListener {
        loadImages()
    }

    protected lateinit var subscription: Disposable
    var searchQuery:String = ""

    fun init() {
        loadImages()
    }

    fun init(query : String) {
        searchQuery = query
        loadImages()
    }

    override fun onCleared() {
        super.onCleared()
        if(subscription != null)
            subscription.dispose()
    }

    open fun loadImages() {
    }

    /**
     * Handles Flickr Api Response
     * @param response Rective Observable for Flickr API response
     */
    open fun handleResponse(response : Observable<FlickrResponse>) {
       subscription = response.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { onRetrieveListStart() }
                .doOnTerminate { onRetrieveListFinish() }
                .subscribe(
                        { onRetrieveImages(it.getImages()!!.photo!!)},
                        {err -> onRetrieveListError(err)}
                )
    }

    /**
     * Shows Loading ProgressBar
     */
    protected fun onRetrieveListStart(){
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    /**
     * Hides ProgressBar
     */
    protected fun onRetrieveListFinish(){
        loadingVisibility.value = View.GONE
    }

    /**
     * Loads Images List to Adapter
     * @param flickrResponse Flickr API response
     */
    protected fun onRetrieveImages(listImages: List<FlickrImage>) {
        imageListAdapter.updateImageList(listImages)

    }

    /**
     * Shows Error Message
     */
    protected fun onRetrieveListError(err:Throwable){
        errorMessage.value = R.string.error
        Log.e("ERROR LOADING", err.localizedMessage)
    }

    fun sort(type : Int) {
          when(type) {
            SORT_TAKEN -> {
                Collections.sort(imageListAdapter.getImageList()) { image, image2 -> (image.dateupload?.toLong()!!.compareTo(DATE_FORMATTER.parse(image2.datetaken).time)) }
                imageListAdapter.notifyDataSetChanged()
            }
            SORT_UPLOADED -> {
                Collections.sort(imageListAdapter.getImageList()) { image, image2 -> (image2.dateupload?.toLong()!!.compareTo(DATE_FORMATTER.parse(image.datetaken).time)) }
                imageListAdapter.notifyDataSetChanged()
            }
        }
    }
}