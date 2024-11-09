package com.stoyanvuchev.snoozeloo.core.presentation.ui.components.card

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import com.stoyanvuchev.snoozeloo.core.presentation.ui.theme.Theme
import com.stoyanvuchev.snoozeloo.core.presentation.ui.theme.color.LocalContentColor
import com.stoyanvuchev.snoozeloo.core.presentation.ui.theme.typeface.LocalTextStyle

@Composable
fun Card(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    containerColor: Color = Theme.colorScheme.surfaceContainer,
    contentColor: Color = Theme.colorScheme.onSurfaceContainer,
    shape: Shape = Theme.shapes.medium,
    content: @Composable () -> Unit
) {

    Box(
        modifier = modifier
            .then(
                Modifier
                    .fillMaxWidth()
                    .clip(shape)
                    .background(color = containerColor)
                    .clickable(onClick = onClick)
            )
    ) {

        CompositionLocalProvider(
            LocalContentColor provides contentColor,
            LocalTextStyle provides Theme.typefaces.bodyLarge,
            content = content
        )

    }

}