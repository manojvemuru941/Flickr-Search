package com.flicker.image.gallery.network

import com.flicker.image.gallery.model.FlickrResponse
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by Manoj Vemuru on 2018-10-19.
 * The interface which provides methods to get result of webservices
 */

interface FlickrApi {
    /**
     * Get the list of the pots from the API
     */
    @GET("/posts")
    fun getFlickrImages(): Observable<FlickrResponse>
}