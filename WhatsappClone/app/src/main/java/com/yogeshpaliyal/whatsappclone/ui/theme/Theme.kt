package com.yogeshpaliyal.whatsappclone.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorPalette = darkColors(
    primary = Teal700,
    primaryVariant = Teal700,
    secondary = Teal700,
    surface = Color.White,
    onPrimary = Color.White,
    onSurface = Color.Black
)

private val DarkColorPalette = lightColors(
    primary = Grey900,
    primaryVariant = Grey900,
    secondary = Teal400,
    surface = Mirage900,
    onPrimary = Color.White,
    onSurface = Color.White

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun WhatsappCloneTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}