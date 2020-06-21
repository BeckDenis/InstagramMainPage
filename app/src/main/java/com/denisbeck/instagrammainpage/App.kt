package com.denisbeck.instagrammainpage

import android.app.Application
import com.denisbeck.instagrammainpage.networking.networkModule
import com.denisbeck.instagrammainpage.repository.postsModule
import com.denisbeck.instagrammainpage.screens.main.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(listOf(viewModelModule, networkModule, postsModule))
        }
    }

}