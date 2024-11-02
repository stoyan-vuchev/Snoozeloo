package com.stoyanvuchev.snoozeloo.core.presentation.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
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

        MaterialTheme(
            typography = Typography,
            content = content
        )

    }

}