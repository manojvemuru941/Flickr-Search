package com.flickr.gallery.injection.module

import android.arch.persistence.room.Room
import com.flickr.gallery.model.FavImageDao
import com.flickr.gallery.model.database.AppDatabase
import com.flickr.gallery.utils.getAppContext
import dagger.Module
import dagger.Provides
import dagger.Reusable

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