package com.stoyanvuchev.snoozeloo.core.presentation.ui.components.topbar.util

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.systemBars
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

object TopBarUtils {

    val containerHeight: Dp get() = 64.dp
    val contentPadding: Dp get() = 8.dp
    val titleHorizontalPadding: Dp get() = 16.dp

    @Composable
    fun windowInsets(): WindowInsets {
        return WindowInsets
            .systemBars
            .only(WindowInsetsSides.Top + WindowInsetsSides.Horizontal)
    }

}