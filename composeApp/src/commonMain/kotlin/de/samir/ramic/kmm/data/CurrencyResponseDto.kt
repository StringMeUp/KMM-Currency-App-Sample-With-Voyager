package de.samir.ramic.kmm.data

import CurrencyData
import de.samir.ramic.kmm.data.MetaData
import kotlinx.serialization.Serializable

@Serializable
data class CurrencyResponseDto(
    val meta: MetaData,
    val data: CurrencyData
)