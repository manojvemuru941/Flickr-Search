package com.flickr.gallery.ui.flickr

import android.arch.lifecycle.MutableLiveData
import com.flickr.gallery.R
import com.flickr.gallery.base.BaseViewModel
import com.flickr.gallery.model.FlickrImage
import com.flickr.gallery.utils.getStringResource

class ImageViewModel:BaseViewModel() {
    private val imageTitle = MutableLiveData<String>()
    private val imageUrl = MutableLiveData<String>()

    /**
     * Binds Flickr Image content
     * @param flickrImage
     */
    fun bind(flickrImage: FlickrImage){
        imageTitle.value = formatMetaData(flickrImage.ownername!!, flickrImage.datetaken!!)
        imageUrl.value = flickrImage.url_s
    }

    fun getImageTitle():MutableLiveData<String>{
        return imageTitle
    }

    fun getImageUrl():MutableLiveData<String>{
        return imageUrl
    }

    /**
     * Provides formatted meta data string for Image
     * @param name Image Owner name
     * @param dateTaken Image date taken
     */
    fun formatMetaData(name: String, dateTaken : String) : String {
        return String.format(getStringResource(R.string.item_meta), name, dateTaken)
    }
}