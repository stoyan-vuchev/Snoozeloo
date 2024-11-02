package com.stoyanvuchev.snoozeloo.core.presentation.ui.theme.color

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
object SnoozelooColorScheme : ColorScheme {

    // Primary Color Group

    override val primary: Color
        get() = Color(0xFF4664FF)

    override val onPrimary: Color
        get() = Color(0xFFFFFFFF)

    override val disabledPrimary: Color
        get() = Color(0xFFBCC6FF)

    override val onDisabledPrimary: Color
        get() = Color(0xFFFFFFFF)

    // Surface (Background) Color Group

    override val surface: Color
        get() = Color(0xFFF3F4F9)

    override val onSurface: Color
        get() = Color(0xFF0D0F19)

    override val surfaceContainer: Color
        get() = Color(0xFFFFFFFF)

    override val onSurfaceContainer: Color
        get() = Color(0xFF0D0F19)

    // Other Colors

    override val outline: Color
        get() = Color(0xFF7A809F)

}

@Immutable
interface ColorScheme {
    val primary: Color
    val onPrimary: Color
    val disabledPrimary: Color
    val onDisabledPrimary: Color
    val surface: Color
    val onSurface: Color
    val surfaceContainer: Color
    val onSurfaceContainer: Color
    val outline: Color
}

val LocalColorScheme = staticCompositionLocalOf<ColorScheme> { SnoozelooColorScheme }