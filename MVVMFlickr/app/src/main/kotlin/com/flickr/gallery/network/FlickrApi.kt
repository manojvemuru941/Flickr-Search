package com.flickr.gallery.network

import com.flickr.gallery.BuildConfig.LATEST
import com.flickr.gallery.model.FlickrResponse
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * The interface which provides methods to get result of webservices
 */
interface FlickrApi {
    /**
     * Get the list of the latest Image from the API
     */
    @GET(LATEST)
    fun getFlickrLatestImages():Observable<FlickrResponse>

    /**
     * Get Image from url
     */
    @GET(LATEST)
    fun getSearchImages():Observable<FlickrResponse>
}