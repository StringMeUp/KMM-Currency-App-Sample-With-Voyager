package de.samir.ramic.kmm.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import kotlinmultiplatformsamplecmp.composeapp.generated.resources.Res
import kotlinmultiplatformsamplecmp.composeapp.generated.resources.roboto_light
import kotlinmultiplatformsamplecmp.composeapp.generated.resources.roboto_medium
import kotlinmultiplatformsamplecmp.composeapp.generated.resources.roboto_regular
import kotlinmultiplatformsamplecmp.composeapp.generated.resources.roboto_semibold
import org.jetbrains.compose.resources.Font

@Composable
fun RobotoFontFamily() = FontFamily(
    Font(resource = Res.font.roboto_light, FontWeight.Normal),
    Font(resource = Res.font.roboto_regular, FontWeight.Normal),
    Font(resource = Res.font.roboto_medium, FontWeight.Normal),
    Font(resource = Res.font.roboto_semibold, FontWeight.Normal)
)
