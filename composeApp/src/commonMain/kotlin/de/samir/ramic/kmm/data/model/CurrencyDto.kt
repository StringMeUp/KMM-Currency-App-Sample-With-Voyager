package de.samir.ramic.kmm.data.model

import kotlinx.serialization.Serializable

@Serializable
data class CurrencyDto(
    val code: String,
    val value: Double
)