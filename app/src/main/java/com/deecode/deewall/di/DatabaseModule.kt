package com.deecode.deewall.di

import android.content.Context
import androidx.room.Room
import com.deecode.deewall.data.local.DeeWallDatabase
import com.deecode.deewall.data.local.dao.WallpaperDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): DeeWallDatabase {
        return Room.databaseBuilder(
            context,
            DeeWallDatabase::class.java,
            "deewall_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideWallpaperDao(database: DeeWallDatabase): WallpaperDao {
        return database.wallpaperDao()
    }
}
