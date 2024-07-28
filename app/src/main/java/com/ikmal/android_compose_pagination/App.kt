package com.ikmal.android_compose_pagination

import android.app.Application
import com.facebook.flipper.BuildConfig
import com.facebook.flipper.android.AndroidFlipperClient
import com.facebook.flipper.android.utils.FlipperUtils
import com.facebook.flipper.plugins.databases.DatabasesFlipperPlugin
import com.facebook.flipper.plugins.inspector.DescriptorMapping
import com.facebook.flipper.plugins.inspector.InspectorFlipperPlugin
import com.facebook.flipper.plugins.network.NetworkFlipperPlugin
import com.facebook.flipper.plugins.sharedpreferences.SharedPreferencesFlipperPlugin
import com.facebook.soloader.SoLoader
import dagger.hilt.android.HiltAndroidApp

/**
 * Flipper Docs : https://fbflipper.com/docs/getting-started/android-native/
 */

@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        SoLoader.init(this, false)
        if (BuildConfig.DEBUG && FlipperUtils.shouldEnableFlipper(this)) {
            AndroidFlipperClient.getInstance(this).run {
                addPlugin(InspectorFlipperPlugin(this@App, DescriptorMapping.withDefaults()))
                addPlugin(NetworkFlipperPlugin())
                addPlugin(SharedPreferencesFlipperPlugin(this@App))
                addPlugin(DatabasesFlipperPlugin(this@App))
                start()
            }
        }
    }
}