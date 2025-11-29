package com.deecode.deewall.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wallpapers")
data class WallpaperEntity(
    @PrimaryKey val id: String,
    val url: String,
    val title: String,
    val isFavorite: Boolean = false
)
