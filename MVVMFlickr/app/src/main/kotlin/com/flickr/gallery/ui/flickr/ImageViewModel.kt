package com.flickr.gallery.ui.flickr

import android.arch.lifecycle.MutableLiveData
import android.view.View
import com.flickr.gallery.R
import com.flickr.gallery.base.BaseViewModel
import com.flickr.gallery.model.FavImageDao
import com.flickr.gallery.model.FlickrImage
import com.flickr.gallery.utils.getStringResource
import io.reactivex.Observable
import javax.inject.Inject
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers



class ImageViewModel:BaseViewModel() {
    @Inject lateinit var favImageDao: FavImageDao
    private lateinit var flickrImage: FlickrImage
    private val imageTitle = MutableLiveData<String>()
    private val imageUrl = MutableLiveData<String>()
    private var onFavClickListener: View.OnClickListener = View.OnClickListener {
        Observable.fromCallable {
            favImageDao.insertFavImage(flickrImage)
            false
        }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { result ->
                    //Use result for something
                }
    }

    /**
     * Binds Flickr Image content
     * @param flickrImage
     */
    fun bind(flickrImage: FlickrImage){
        imageTitle.value = formatMetaData(flickrImage.ownername!!, flickrImage.datetaken!!)
        imageUrl.value = flickrImage.url_s
        this.flickrImage = flickrImage
    }

    fun getImageTitle():MutableLiveData<String>{
        return imageTitle
    }

    fun getImageUrl():MutableLiveData<String>{
        return imageUrl
    }

    fun getFavOnClick() : View.OnClickListener {
        return onFavClickListener
    }

    /**
     * Provides formatted meta data string for Image
     * @param name Image Owner name
     * @param dateTaken Image date taken
     *
     * @return returns formatted String
     */
    private fun formatMetaData(name: String, dateTaken : String) : String {
        return String.format(getStringResource(R.string.item_meta), name, dateTaken)
    }
}