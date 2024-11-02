package com.stoyanvuchev.snoozeloo.core.presentation.ui.theme.typeface

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.stoyanvuchev.snoozeloo.R

@Immutable
object SnoozelooTypefaces : Typefaces {

    override val displayExtra: TextStyle
        get() = TextStyle(
            fontFamily = MontserratFontFamily,
            fontWeight = FontWeight(500),
            fontSize = 82.0.sp,
            lineHeight = 99.96.sp,
            letterSpacing = 0.0.sp
        )

    override val displayLarge: TextStyle
        get() = TextStyle(
            fontFamily = MontserratFontFamily,
            fontWeight = FontWeight(500),
            fontSize = 52.0.sp,
            lineHeight = 63.39.sp,
            letterSpacing = 0.0.sp
        )

    override val displayMedium: TextStyle
        get() = TextStyle(
            fontFamily = MontserratFontFamily,
            fontWeight = FontWeight(500),
            fontSize = 42.0.sp,
            lineHeight = 51.2.sp,
            letterSpacing = 0.0.sp
        )

    override val displaySmall: TextStyle
        get() = TextStyle(
            fontFamily = MontserratFontFamily,
            fontWeight = FontWeight(500),
            fontSize = 24.0.sp,
            lineHeight = 29.26.sp,
            letterSpacing = 0.0.sp
        )

    override val labelMedium: TextStyle
        get() = TextStyle(
            fontFamily = MontserratFontFamily,
            fontWeight = FontWeight(600),
            fontSize = 16.0.sp,
            lineHeight = 19.5.sp,
            letterSpacing = 0.0.sp
        )

    override val bodyLarge: TextStyle
        get() = TextStyle(
            fontFamily = MontserratFontFamily,
            fontWeight = FontWeight(500),
            fontSize = 16.0.sp,
            lineHeight = 19.5.sp,
            letterSpacing = 0.0.sp
        )

    override val bodyMedium: TextStyle
        get() = TextStyle(
            fontFamily = MontserratFontFamily,
            fontWeight = FontWeight(500),
            fontSize = 14.0.sp,
            lineHeight = 17.07.sp,
            letterSpacing = 0.0.sp
        )

}

@Immutable
interface Typefaces {
    val displayExtra: TextStyle
    val displayLarge: TextStyle
    val displayMedium: TextStyle
    val displaySmall: TextStyle
    val labelMedium: TextStyle
    val bodyLarge: TextStyle
    val bodyMedium: TextStyle
}

private val MontserratFontFamily: FontFamily
    get() = FontFamily(
        fonts = listOf(
            Font(
                resId = R.font.montserrat_black,
                weight = FontWeight.Black
            ),
            Font(
                resId = R.font.montserrat_extrabold,
                weight = FontWeight.ExtraBold
            ),
            Font(
                resId = R.font.montserrat_bold,
                weight = FontWeight.Bold
            ),
            Font(
                resId = R.font.montserrat_semibold,
                weight = FontWeight.SemiBold
            ),
            Font(
                resId = R.font.montserrat_medium,
                weight = FontWeight.Medium
            ),
            Font(
                resId = R.font.montserrat_regular,
                weight = FontWeight.Normal
            ),
            Font(
                resId = R.font.montserrat_light,
                weight = FontWeight.Light
            ),
            Font(
                resId = R.font.montserrat_extralight,
                weight = FontWeight.ExtraLight
            ),
            Font(
                resId = R.font.montserrat_thin,
                weight = FontWeight.Thin
            )
        )
    )

val LocalTypefaces = staticCompositionLocalOf<Typefaces> { SnoozelooTypefaces }
val LocalTextStyle = staticCompositionLocalOf { SnoozelooTypefaces.bodyLarge }