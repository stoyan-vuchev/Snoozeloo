package com.stoyanvuchev.snoozeloo.core.presentation.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.ReadOnlyComposable
import com.stoyanvuchev.snoozeloo.core.presentation.ui.theme.color.ColorScheme
import com.stoyanvuchev.snoozeloo.core.presentation.ui.theme.color.LocalColorScheme
import com.stoyanvuchev.snoozeloo.core.presentation.ui.theme.color.LocalContentColor
import com.stoyanvuchev.snoozeloo.core.presentation.ui.theme.shape.LocalShapes
import com.stoyanvuchev.snoozeloo.core.presentation.ui.theme.shape.Shapes
import com.stoyanvuchev.snoozeloo.core.presentation.ui.theme.typeface.LocalTextStyle
import com.stoyanvuchev.snoozeloo.core.presentation.ui.theme.typeface.LocalTypefaces
import com.stoyanvuchev.snoozeloo.core.presentation.ui.theme.typeface.Typefaces
import com.stoyanvuchev.systemuibarstweaker.ProvideSystemUIBarsTweaker
import com.stoyanvuchev.systemuibarstweaker.ScrimStyle
import com.stoyanvuchev.systemuibarstweaker.rememberSystemUIBarsTweaker

@Composable
fun SnoozelooTheme(
    content: @Composable () -> Unit
) {

    val systemUIBarsTweaker = rememberSystemUIBarsTweaker()

    DisposableEffect(systemUIBarsTweaker) {

        systemUIBarsTweaker.tweakSystemBarsStyle(
            statusBarStyle = systemUIBarsTweaker.statusBarStyle.copy(
                darkIcons = true,
                scrimStyle = ScrimStyle.None
            ),
            navigationBarStyle = systemUIBarsTweaker.statusBarStyle.copy(
                darkIcons = true,
                scrimStyle = if (systemUIBarsTweaker.isGestureNavigationEnabled) {
                    ScrimStyle.None
                } else ScrimStyle.System
            )
        )

        onDispose { }

    }

    ProvideSystemUIBarsTweaker(
        systemUIBarsTweaker = systemUIBarsTweaker
    ) {

        CompositionLocalProvider(
            LocalContentColor provides Theme.colorScheme.onSurface,
            LocalTextStyle provides Theme.typefaces.bodyLarge,
            content = content
        )

    }

}

object Theme {

    val colorScheme: ColorScheme
        @ReadOnlyComposable
        @Composable
        get() = LocalColorScheme.current

    val shapes: Shapes
        @ReadOnlyComposable
        @Composable
        get() = LocalShapes.current

    val typefaces: Typefaces
        @ReadOnlyComposable
        @Composable
        get() = LocalTypefaces.current

}