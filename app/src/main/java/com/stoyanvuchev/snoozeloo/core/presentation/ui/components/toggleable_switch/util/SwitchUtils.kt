package com.stoyanvuchev.snoozeloo.core.presentation.ui.components.toggleable_switch.util

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.stoyanvuchev.snoozeloo.core.presentation.ui.components.toggleable_switch.SwitchColors
import com.stoyanvuchev.snoozeloo.core.presentation.ui.theme.Theme

object SwitchUtils {

    val switchToggleRadius: Dp get() = 16.dp
    val switchContainerSize: DpSize
        get() = DpSize(
            width = 60.dp,
            height = 36.dp
        )

    val containerShape: Shape get() = RoundedCornerShape(50)

    @Composable
    fun switchColors(
        switchedOnBackgroundColor: Color = Theme.colorScheme.primary,
        switchedOnToggleColor: Color = Theme.colorScheme.onPrimary,
        switchedOffBackgroundColor: Color = Theme.colorScheme.primary.copy(alpha = .33f),
        switchedOffToggleColor: Color = Theme.colorScheme.onPrimary,
    ) = SwitchColors(
        switchedOnBackgroundColor = switchedOnBackgroundColor,
        switchedOnToggleColor = switchedOnToggleColor,
        switchedOffBackgroundColor = switchedOffBackgroundColor,
        switchedOffToggleColor = switchedOffToggleColor
    )

}