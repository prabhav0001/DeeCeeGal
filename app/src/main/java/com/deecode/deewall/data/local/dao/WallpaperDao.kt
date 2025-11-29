package com.deecode.deewall.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.deecode.deewall.data.local.entity.WallpaperEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WallpaperDao {
    @Query("SELECT * FROM wallpapers")
    fun getAllWallpapers(): Flow<List<WallpaperEntity>>

    @Query("SELECT * FROM wallpapers WHERE isFavorite = 1")
    fun getFavoriteWallpapers(): Flow<List<WallpaperEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWallpaper(wallpaper: WallpaperEntity)

    @Query("DELETE FROM wallpapers WHERE id = :id")
    suspend fun deleteWallpaper(id: String)
}
