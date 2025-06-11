package de.samir.ramic.kmm.ui.theme

import androidx.compose.ui.graphics.Color

val LightBlue = Color(0xFF1BE7FF)
val MintGreen = Color(0xFF6EEB83)
val NeonYellow = Color(0xFFE4FF1A)
val OrangeYellow = Color(0xFFFFB800)
val BrightOrange = Color(0xFFFF5714)
val ReisinBlack = Color(0xFF161925)
val OxfordBlue = Color(0xFF23395B)
val UclaBlue = Color(0xFF406E8E)
val UclaBlue2 = Color(0xFFB85A6DF)
val PowderBlue = Color(0xFF8EA8C3)
val AeroBlue = Color(0xFFCBF7ED)
val BlueyBlue = Color(0xFFA1E3D8)
val Amber = Color(0xFFFFC107)
val SoftPeach = Color(0xFFFFB74D)
val SoftPaper = Color(0xFFFAFAFA)
val SystemGray = Color(0xFF535353)
val SystemGray2 = Color(0xFF181818)
val SystemBackground = Color(0xFF111111)
val SystemHiglight = Color(0xFFB14E3F)

val LightColorScheme = androidx.compose.material3.lightColorScheme(
    primary = OxfordBlue,
    onPrimary = AeroBlue,
    secondary = UclaBlue,
    onSecondary = Color.White,
    tertiary = PowderBlue,
    onTertiary = Color.Black,
    background = AeroBlue,
    onBackground = ReisinBlack,
    surface = Color.White,
    onSurface = OxfordBlue
)

val DarkColorScheme = androidx.compose.material3.darkColorScheme(
    primary = OxfordBlue,
    onPrimary = AeroBlue,
    secondary = UclaBlue,
    onSecondary = Color.Black,
    tertiary = PowderBlue,
    onTertiary = Color.Black,
    background = ReisinBlack,
    onBackground = AeroBlue,
    surface = Color(0xFF1F1F28),
    onSurface = AeroBlue
)
