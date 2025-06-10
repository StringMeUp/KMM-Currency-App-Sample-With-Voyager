package de.samir.ramic.kmm.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf

val LocalAppTypography = staticCompositionLocalOf { AppTypography }

@Composable
fun AppTheme(
    typography: AppTypography = AppTypography,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalAppTypography provides typography,
        content = content
    )
}