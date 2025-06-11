package de.samir.ramic.kmm.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import kotlinmultiplatformsamplecmp.composeapp.generated.resources.Res
import kotlinmultiplatformsamplecmp.composeapp.generated.resources.roboto_light
import kotlinmultiplatformsamplecmp.composeapp.generated.resources.roboto_medium
import kotlinmultiplatformsamplecmp.composeapp.generated.resources.roboto_regular
import kotlinmultiplatformsamplecmp.composeapp.generated.resources.roboto_semibold
import org.jetbrains.compose.resources.Font

object AppTypography {

    @Composable
    fun headlineLarge(): TextStyle = TextStyle(
        fontFamily = FontFamily(Font(resource = Res.font.roboto_regular, FontWeight.Normal)),
        fontSize = 18.sp,
        fontWeight = FontWeight.Light,
        color = Color.White
    )

    @Composable
    fun body(): TextStyle = TextStyle(
        fontFamily = FontFamily(Font(resource = Res.font.roboto_light)),
        fontSize = 16.sp,
        color = Color.White
    )

    @Composable
    fun bodySemiBold(): TextStyle = TextStyle(
        fontFamily = FontFamily(Font(resource = Res.font.roboto_semibold)),
        fontSize = 16.sp,
        color = Color.White
    )

    @Composable
    fun regular(): TextStyle = TextStyle(
        fontFamily = FontFamily(Font(resource = Res.font.roboto_regular)),
        fontSize = 14.sp,
        color = Color.White
    )

    @Composable
    fun caption(): TextStyle = TextStyle(
        fontFamily = FontFamily(Font(resource = Res.font.roboto_regular)),
        fontSize = 12.sp,
        fontWeight = FontWeight.Light,
        color = Color.White
    )

    @Composable
    fun captionSemiBold(): TextStyle = TextStyle(
        fontFamily = FontFamily(Font(resource = Res.font.roboto_semibold)),
        fontSize = 12.sp,
        color = Color.White
    )
}