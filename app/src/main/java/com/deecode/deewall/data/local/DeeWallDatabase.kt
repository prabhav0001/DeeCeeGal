package com.deecode.deewall.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.deecode.deewall.data.local.dao.WallpaperDao
import com.deecode.deewall.data.local.entity.WallpaperEntity

@Database(entities = [WallpaperEntity::class], version = 1, exportSchema = false)
abstract class DeeWallDatabase : RoomDatabase() {
    abstract fun wallpaperDao(): WallpaperDao
}
