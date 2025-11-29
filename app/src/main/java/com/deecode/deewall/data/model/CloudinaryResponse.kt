package com.deecode.deewall.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CloudinaryListResponse(
    val resources: List<CloudinaryResource>
)

@Serializable
data class CloudinaryResource(
    @SerialName("public_id") val publicId: String,
    val format: String,
    val version: Long,
    val type: String,
    @SerialName("created_at") val createdAt: String
)
