package com.flicker.image.gallery.di.component

import com.flicker.image.gallery.di.module.NetworkModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Manoj Vemuru on 2018-10-19.
 */
@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {

    @Component.Builder
    interface Builder {
        fun build() : ViewModelInjector

        fun networkModule(networkModule : NetworkModule) : Builder
    }
}