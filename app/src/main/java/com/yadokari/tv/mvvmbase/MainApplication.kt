package com.yadokari.tv.mvvmbase

import android.app.Application
import androidx.multidex.MultiDex
import com.yadokari.tv.mvvmbase.di.AppModule
import com.yadokari.tv.mvvmbase.di.NetworkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level

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