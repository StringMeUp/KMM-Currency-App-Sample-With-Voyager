package de.samir.ramic.kmm.data.model

import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.format
import kotlinx.datetime.format.FormatStringsInDatetimeFormats
import kotlinx.datetime.format.byUnicodePattern
import kotlinx.datetime.toLocalDateTime
import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@Serializable
data class MetaData(
    @SerialName(value = "last_updated_at")
    val lastUpdatedAt: String
) {
    @OptIn(ExperimentalTime::class)
    @Contextual
    private val instantTime = Instant.parse(lastUpdatedAt)
    @OptIn(ExperimentalTime::class)
    private val localTime = instantTime.toLocalDateTime(TimeZone.currentSystemDefault())
    @OptIn(FormatStringsInDatetimeFormats::class)
    private val format = LocalDateTime.Format {
        byUnicodePattern("dd.MM.yyyy HH:mm")
    }
    val formattedUpdateTime = localTime.format(format)
}