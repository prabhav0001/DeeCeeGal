package com.deecode.deewall.domain.repository

import com.deecode.deewall.data.local.entity.WallpaperEntity
import kotlinx.coroutines.flow.Flow

interface WallpaperRepository {
    fun getWallpapers(): Flow<List<WallpaperEntity>>
    fun getFavoriteWallpapers(): Flow<List<WallpaperEntity>>
    suspend fun refreshWallpapers()
    suspend fun toggleFavorite(wallpaper: WallpaperEntity)
}
