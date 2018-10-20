package com.flickr.gallery.ui.flickr

import android.arch.lifecycle.MutableLiveData
import android.net.Uri
import com.flickr.gallery.base.BaseViewModel
import com.flickr.gallery.model.FlickrImage

class ImageViewModel:BaseViewModel() {
    private val imageTitle = MutableLiveData<String>()
    private val imageUrl = MutableLiveData<String>()

    fun bind(flickrImage: FlickrImage){
        imageTitle.value = flickrImage.id
        imageUrl.value = flickrImage.url_s
    }

    fun getImageTitle():MutableLiveData<String>{
        return imageTitle
    }

    fun getImageUrl():MutableLiveData<String>{
        return imageUrl
    }
}