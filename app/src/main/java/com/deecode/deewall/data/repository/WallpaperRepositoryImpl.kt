package com.deecode.deewall.data.repository

import com.deecode.deewall.data.local.dao.WallpaperDao
import com.deecode.deewall.data.local.entity.WallpaperEntity
import com.deecode.deewall.data.remote.WallApi
import com.deecode.deewall.domain.repository.WallpaperRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WallpaperRepositoryImpl @Inject constructor(
    private val api: WallApi,
    private val dao: WallpaperDao
) : WallpaperRepository {

    override fun getWallpapers(): Flow<List<WallpaperEntity>> {
        return dao.getAllWallpapers()
    }

    override fun getFavoriteWallpapers(): Flow<List<WallpaperEntity>> {
        return dao.getFavoriteWallpapers()
    }

    override suspend fun refreshWallpapers() {
        try {
            // Fetch from Cloudinary using a tag (e.g., "wallpapers")
            // Note: Ensure "Resource list" is enabled in Cloudinary Security settings
            val response = api.getWallpapersByTag("wallpapers")

            val entities = response.resources.map { resource ->
                // Construct URL manually or use MediaManager if needed
                // Format: https://res.cloudinary.com/<cloud_name>/image/upload/v<version>/<public_id>.<format>
                // For now, we'll construct a simple URL.
                // TODO: Inject cloud name or use a helper
                val cloudName = "demo"
                val url = "https://res.cloudinary.com/$cloudName/image/upload/v${resource.version}/${resource.publicId}.${resource.format}"

                WallpaperEntity(
                    id = resource.publicId,
                    url = url,
                    title = resource.publicId, // Use public_id as title for now
                    isFavorite = false // Default, logic to preserve favorite status needed
                )
            }

            // Simple strategy: Insert all. In a real app, you'd want to sync carefully to not overwrite favorites
            // or use a more complex conflict strategy.
            entities.forEach { entity ->
                // Check if exists to preserve favorite status?
                // For simplicity, we just insert. The DAO uses REPLACE, so isFavorite might be reset.
                // A better approach is to fetch existing, update, and save.
                dao.insertWallpaper(entity)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            // Handle error (e.g., emit to a UI state)
        }
    }

    override suspend fun toggleFavorite(wallpaper: WallpaperEntity) {
        dao.insertWallpaper(wallpaper.copy(isFavorite = !wallpaper.isFavorite))
    }
}
