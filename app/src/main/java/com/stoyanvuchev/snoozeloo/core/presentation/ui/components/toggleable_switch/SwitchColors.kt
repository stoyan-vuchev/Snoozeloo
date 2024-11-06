package com.stoyanvuchev.snoozeloo.core.presentation.ui.components.toggleable_switch

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.graphics.Color

@Stable
data class SwitchColors(
    private val switchedOnBackgroundColor: Color,
    private val switchedOnToggleColor: Color,
    private val switchedOffBackgroundColor: Color,
    private val switchedOffToggleColor: Color,
) {

    @Composable
    internal fun backgroundColor(switched: Boolean): State<Color> {
        return rememberUpdatedState(
            if (switched) switchedOnBackgroundColor
            else switchedOffBackgroundColor
        )
    }

    @Composable
    internal fun toggleColor(switched: Boolean): State<Color> {
        return rememberUpdatedState(
            if (switched) switchedOnToggleColor
            else switchedOffToggleColor
        )
    }

}