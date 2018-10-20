package com.flickr.gallery.ui.flickr

import android.arch.lifecycle.MutableLiveData
import android.view.View
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import com.flickr.gallery.R
import com.flickr.gallery.base.BaseViewModel
import com.flickr.gallery.model.FlickrResponse
import com.flickr.gallery.model.FavImageDao
import com.flickr.gallery.network.FlickrApi
import javax.inject.Inject

class FlickrImageListViewModel(private val favImageDao: FavImageDao):BaseViewModel(){
    @Inject
    lateinit var flickrApi: FlickrApi
    val imageListAdapter: FlickrImageListAdapter = FlickrImageListAdapter()

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage:MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener { loadImages() }

    private lateinit var subscription: Disposable

    init{
        loadImages()
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

    private fun loadImages(){
        subscription = flickrApi.getFlickrLatestImages()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { onRetrieveListStart() }
                .doOnTerminate { onRetrieveListFinish() }
                .subscribe(
                        { onRetrieveImages(it)},
                        { onRetrieveListError()}
                )
    }

    private fun onRetrieveListStart(){
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    private fun onRetrieveListFinish(){
        loadingVisibility.value = View.GONE
    }

    private fun onRetrieveImages(flickrResponse: FlickrResponse) {
        imageListAdapter.updateImageList(flickrResponse.items!!)

    }

    private fun onRetrieveListError(){
        errorMessage.value = R.string.error
    }
}