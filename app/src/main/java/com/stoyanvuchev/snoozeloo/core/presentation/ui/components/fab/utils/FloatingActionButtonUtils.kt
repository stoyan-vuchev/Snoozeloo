package com.stoyanvuchev.snoozeloo.core.presentation.ui.components.fab.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.stoyanvuchev.snoozeloo.core.presentation.ui.theme.Theme

object FloatingActionButtonUtils {

    val containerSize: Dp get() = 64.dp
    val containerShape: Shape
        @Composable get() = Theme.shapes.large

    val contentSize: Dp get() = containerSize * .67f

}