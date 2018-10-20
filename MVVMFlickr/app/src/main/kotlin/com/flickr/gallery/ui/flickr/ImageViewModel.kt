package com.flickr.gallery.ui.flickr

import android.arch.lifecycle.MutableLiveData
import com.flickr.gallery.base.BaseViewModel
import com.flickr.gallery.model.FlickrImage
import com.flickr.gallery.model.FlickrImages

class ImageViewModel:BaseViewModel() {
    private val imageTitle = MutableLiveData<String>()
    private val imageBody = MutableLiveData<String>()

    fun bind(flickrImage: FlickrImage){
        imageTitle.value = flickrImage.getId()
        imageBody.value = flickrImage.getImageUrl()
    }

    fun getImageTitle():MutableLiveData<String>{
        return imageTitle
    }

    fun getImageBody():MutableLiveData<String>{
        return imageBody
    }
}