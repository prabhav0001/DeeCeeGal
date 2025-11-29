package com.deecode.deewall.di

import android.content.Context
import com.cloudinary.android.MediaManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CloudinaryModule {

    @Provides
    @Singleton
    fun provideMediaManager(@ApplicationContext context: Context): MediaManager {
        val config = HashMap<String, String>()
        config["cloud_name"] = "demo" // TODO: Replace with your Cloudinary cloud name
        config["secure"] = "true"
        MediaManager.init(context, config)
        return MediaManager.get()
    }
}
