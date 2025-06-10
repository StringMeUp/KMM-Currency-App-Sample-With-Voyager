package de.samir.ramic.kmm.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import kotlinmultiplatformsamplecmp.composeapp.generated.resources.Res
import kotlinmultiplatformsamplecmp.composeapp.generated.resources.roboto_regular
import org.jetbrains.compose.resources.Font

object AppTypography {

    @Composable
    fun headlineLarge(): TextStyle = TextStyle(
        fontFamily = FontFamily(Font(resource = Res.font.roboto_regular, FontWeight.Normal)),
        fontSize = 32.sp,
        fontWeight = FontWeight.Light
    )

    @Composable
    fun body(): TextStyle = TextStyle(
        fontFamily = FontFamily(Font(resource = Res.font.roboto_regular, FontWeight.Normal)),
        fontSize = 16.sp,
        fontWeight = FontWeight.Light
    )
    @Composable
    fun caption(): TextStyle = TextStyle(
        fontFamily = FontFamily(Font(resource = Res.font.roboto_regular, FontWeight.Normal)),
        fontSize = 12.sp,
        fontWeight = FontWeight.Light
    )
}