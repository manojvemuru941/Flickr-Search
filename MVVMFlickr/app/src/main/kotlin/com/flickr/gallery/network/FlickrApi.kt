package com.flickr.gallery.network

import com.flickr.gallery.model.FlickrResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * The interface which provides methods to get result of webservices
 */
interface FlickrApi {
    /**
     * Get the list of the latest Image from the API
     */
    @GET("rest")
    fun getFlickrLatestImages(@Query("method") methodName :String, @Query("api_key") API_KEY:String, @Query("format") format:String,
                              @Query("nojsoncallback") value:Int, @Query("extras") urlS: String):Observable<FlickrResponse>

    /**
     * Get list of latest Image by Tag from url
     *  @param query
     */
    @GET("rest")
    fun getSearchImages(@Query("method") methodName :String, @Query("api_key") API_KEY:String, @Query("format") format:String,
                        @Query("nojsoncallback") value:Int, @Query("extras") urlS: String,@Query("text") userSearchText: String):Observable<FlickrResponse>
}