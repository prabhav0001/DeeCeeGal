package com.deecode.deewall.data.remote

import com.deecode.deewall.data.model.CloudinaryListResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface WallApi {
    @GET("image/list/{tag}.json")
    suspend fun getWallpapersByTag(@Path("tag") tag: String): CloudinaryListResponse
}
