package com.yadokari.tv.mvvmbase

import android.app.Application
import androidx.multidex.MultiDex

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@MainApplication)
            modules(listOf(AppModule, NetworkModule))
        }

    }
}