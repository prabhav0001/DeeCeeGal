package com.deecode.deewall.di

import com.deecode.deewall.data.repository.WallpaperRepositoryImpl
import com.deecode.deewall.domain.repository.WallpaperRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindWallpaperRepository(
        wallpaperRepositoryImpl: WallpaperRepositoryImpl
    ): WallpaperRepository
}
