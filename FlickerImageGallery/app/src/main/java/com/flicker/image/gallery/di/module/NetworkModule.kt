package com.flicker.image.gallery.di.module

import com.flicker.image.gallery.BuildConfig
import com.flicker.image.gallery.network.FlickrApi
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by Manoj Vemuru on 2018-10-19.
 * Module which provides all required dependencies about network
 */

@Module
object NetworkModule {

    /**
     * Provides the Flickr API service implementation.
     * @param retrofit the Retrofit object used to instantiate the service
     * @return the FlickrApi service implementation.
     */
    @Provides
    @Reusable
    @JvmStatic
    internal fun provideFlickrApi(retrofit: Retrofit): FlickrApi {
        return retrofit.create(FlickrApi::class.java)
    }

    /**
     * Provides the Retrofit object.
     * @return the Retrofit object
     */
    @Provides
    @Reusable
    @JvmStatic
    internal fun provideRetrofitInterface(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASEURL)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()
    }
}