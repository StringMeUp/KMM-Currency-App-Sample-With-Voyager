package de.samir.ramic.kmm.data.model

import kotlinx.serialization.Serializable

@Serializable
data class CurrencyResponseDto(
    val meta: MetaData,
    val data: CurrencyData
)