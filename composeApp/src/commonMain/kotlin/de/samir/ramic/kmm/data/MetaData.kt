package de.samir.ramic.kmm.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MetaData(
    @SerialName(value = "last_updated_at")
    val lastUpdatedAt: String
)