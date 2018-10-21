package com.flickr.gallery.injection.module

import android.arch.persistence.room.Room
import android.content.Context
import com.flickr.gallery.BuildConfig
import com.flickr.gallery.model.FavImageDao
import com.flickr.gallery.model.database.AppDatabase
import com.flickr.gallery.network.FlickrApi
import com.flickr.gallery.utils.getAppContext
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by Manoj Vemuru on 2018-10-21.
 * Retrofit Module which provides all required dependencies about network
*/
@Module
object DBModule {

    /**
     * Provides FavImageDao service implementation
     * @return the FaveImageDao
     */
    @Provides
    @Reusable
    @JvmStatic
    internal fun provideFavImageDao(appDatabase: AppDatabase) : FavImageDao {
        return appDatabase.favImageDao()
    }

    /**
     * Provides the App Database service implementation.
     * @return the AppDatabase service implementation.
     */
    @Provides
    @Reusable
    @JvmStatic
    internal fun provideDatabaseApi(): AppDatabase {
        return Room.databaseBuilder(getAppContext(), AppDatabase::class.java, "favs").build()
    }
}