package com.flickr.gallery.ui.flickr

import android.arch.lifecycle.MutableLiveData
import android.view.View
import com.flickr.gallery.BuildConfig
import com.flickr.gallery.R
import com.flickr.gallery.base.BaseViewModel
import com.flickr.gallery.model.FlickrResponse
import com.flickr.gallery.network.FlickrApi
import com.flickr.gallery.ui.flickr.adapters.FlickrImageListAdapter
import com.flickr.gallery.utils.*
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Manoj Vemuru on 2018-10-20.
 */

class ListFragmentViewModel : BaseViewModel() {
    @Inject
    lateinit var flickrApi: FlickrApi
    val imageListAdapter: FlickrImageListAdapter = FlickrImageListAdapter()

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage: MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener { loadImages("") }

    private lateinit var subscription: Disposable

    fun init() {
        loadImages("")
    }

    fun init(query : String) {
        loadImages(query)
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

    private fun loadImages(query : String) {
        if(query.isBlank()) {
            handleResponse(flickrApi.getFlickrLatestImages(METHOD_NAME_RECENT, BuildConfig.FLICKR_API_TOKEN, FORMAT, NO_JSON_CALL_BACK, EXTRAS))
        } else {
            handleResponse(flickrApi.getSearchImages(METHOD_NAME_SEARCH, BuildConfig.FLICKR_API_TOKEN, FORMAT, NO_JSON_CALL_BACK, EXTRAS, query))
        }
    }

    /**
     * Handles Flickr Api Response
     * @param response Rective Observable for Flickr API response
     */
    private fun handleResponse(response : Observable<FlickrResponse>) {
       subscription = response.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { onRetrieveListStart() }
                .doOnTerminate { onRetrieveListFinish() }
                .subscribe(
                        { onRetrieveImages(it)},
                        {err -> onRetrieveListError(err)}
                )
    }

    /**
     * Shows Loading ProgressBar
     */
    private fun onRetrieveListStart(){
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    /**
     * Hides ProgressBar
     */
    private fun onRetrieveListFinish(){
        loadingVisibility.value = View.GONE
    }

    /**
     * Loads Images List to Adapter
     * @param flickrResponse Flickr API response
     */
    private fun onRetrieveImages(flickrResponse: FlickrResponse) {
        imageListAdapter.updateImageList(flickrResponse.getImages()!!)

    }

    /**
     * Shows Error Message
     */
    private fun onRetrieveListError(err:Any){
        errorMessage.value = R.string.error
    }
}