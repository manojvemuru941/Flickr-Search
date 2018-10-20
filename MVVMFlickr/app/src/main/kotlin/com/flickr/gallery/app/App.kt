package com.flickr.gallery.app

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import com.flickr.gallery.utils.INIT

/**
 * Created by Manoj Vemuru on 2018-10-20.
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
        INIT(this)
    }
}