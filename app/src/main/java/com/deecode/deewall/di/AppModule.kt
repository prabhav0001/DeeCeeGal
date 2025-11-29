package com.deecode.deewall.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // TODO: Add app-wide dependencies here (e.g., Retrofit, Room Database)

    @Provides
    @Singleton
    fun provideExampleString(): String {
        return "Hello from Hilt!"
    }
}
