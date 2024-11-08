package com.stoyanvuchev.snoozeloo.core.presentation.ui.components.fab

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import com.stoyanvuchev.snoozeloo.core.presentation.ui.components.fab.utils.FloatingActionButtonUtils
import com.stoyanvuchev.snoozeloo.core.presentation.ui.theme.SnoozelooTheme
import com.stoyanvuchev.snoozeloo.core.presentation.ui.theme.Theme
import com.stoyanvuchev.snoozeloo.core.presentation.ui.theme.color.LocalContentColor

@Composable
fun FloatingActionButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    content: @Composable () -> Unit = { DefaultFloatingActionButtonContent() }
) {

    Box(
        modifier = modifier
            .then(
                Modifier
                    .size(FloatingActionButtonUtils.containerSize)
                    .clip(FloatingActionButtonUtils.containerShape)
                    .background(color = Theme.colorScheme.primary)
                    .clickable(onClick = onClick)
            ),
        contentAlignment = Alignment.Center,
        content = {

            CompositionLocalProvider(
                LocalContentColor provides Theme.colorScheme.onPrimary,
                content = content
            )

        }
    )

}

@Preview
@Composable
private fun FloatingActionButtonPreview() = SnoozelooTheme {
    FloatingActionButton(
        onClick = { }
    )
}