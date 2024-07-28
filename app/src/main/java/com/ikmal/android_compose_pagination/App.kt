package com.ikmal.android_compose_pagination

import android.app.Application
import com.facebook.stetho.Stetho
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        initStetho()
    }

    /**
     * Stetho network debugger
     * using this chromium for stable debugger
     * -https://commondatastorage.googleapis.com/chromium-browser-snapshots/index.html?prefix=Mac/827102/
     *
     * visit this link for more docs
     * -https://github.com/facebook/stetho
     * -https://facebook.github.io/stetho/
     */
    private fun initStetho() {
        Stetho.initializeWithDefaults(this)
    }
}