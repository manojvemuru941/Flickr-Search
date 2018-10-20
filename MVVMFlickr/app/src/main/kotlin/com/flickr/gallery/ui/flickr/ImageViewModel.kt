package com.flickr.gallery.ui.flickr

import android.arch.lifecycle.MutableLiveData
import com.flickr.gallery.base.BaseViewModel
import com.flickr.gallery.model.FlickrImage

class ImageViewModel:BaseViewModel() {
    private val imageTitle = MutableLiveData<String>()
    private val imageBody = MutableLiveData<String>()

    fun bind(flickrImage: FlickrImage){
        imageTitle.value = flickrImage.title
        imageBody.value = flickrImage.imageURL
    }

    fun getImageTitle():MutableLiveData<String>{
        return imageTitle
    }

    fun getImageBody():MutableLiveData<String>{
        return imageBody
    }
}