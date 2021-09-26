package com.yogeshpaliyal.whatsappclone.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Teal700 = Color(0xFF008069)
val Teal400 = Color(0xFF00A884)

val Grey900 = Color(0xFF202C33)
val Mirage900 = Color(0xFF111B21)
val Mirage500 = Color(0xFF888D90)
val Mirage400 = Color(0xFF8696A0)

@Composable
fun PrimaryTextColor() = if(isSystemInDarkTheme()) Color.White else Mirage900

@Composable
fun SecondaryTextColor() = if(isSystemInDarkTheme()) Mirage500 else Mirage400
