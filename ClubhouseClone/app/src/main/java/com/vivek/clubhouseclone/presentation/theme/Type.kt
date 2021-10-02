package com.vivek.clubhouseclone.presentation.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.vivek.clubhouseclone.R

private val sf = FontFamily(
    Font(R.font.sf_regular, FontWeight.Normal),
    Font(R.font.sf_medium, FontWeight.Medium),
    Font(R.font.sf_semibold, FontWeight.SemiBold),
    Font(R.font.sf_bold, FontWeight.Bold),
)

val typography = Typography(
    h4 = TextStyle(
        fontFamily = sf,
        fontWeight = FontWeight.W600,
        fontSize = 30.sp
    ),
    h5 = TextStyle(
        fontFamily = sf,
        fontWeight = FontWeight.W600,
        fontSize = 24.sp
    ),
    h6 = TextStyle(
        fontFamily = sf,
        fontWeight = FontWeight.W600,
        fontSize = 20.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = sf,
        fontWeight = FontWeight.W600,
        fontSize = 18.sp
    ),
    subtitle2 = TextStyle(
        fontFamily = sf,
        fontWeight = FontWeight.W500,
        fontSize = 18.sp
    ),
    body1 = TextStyle(
        fontFamily = sf,
        fontWeight = FontWeight.W600,
        fontSize = 16.sp
    ),
    body2 = TextStyle(
        fontFamily = sf,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    button = TextStyle(
        fontFamily = sf,
        fontWeight = FontWeight.W500,
        fontSize = 16.sp
    ),
    caption = TextStyle(
        fontFamily = sf,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    overline = TextStyle(
        fontFamily = sf,
        fontWeight = FontWeight.W500,
        fontSize = 12.sp
    )
)