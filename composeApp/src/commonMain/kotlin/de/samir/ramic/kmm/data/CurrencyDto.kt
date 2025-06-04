package de.samir.ramic.kmm.data

import kotlinx.serialization.Serializable

@Serializable
data class CurrencyDto(
    val code: String,
    val value: Double
)