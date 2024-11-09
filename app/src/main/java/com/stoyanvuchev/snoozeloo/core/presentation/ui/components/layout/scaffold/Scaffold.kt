package com.stoyanvuchev.snoozeloo.core.presentation.ui.components.layout.scaffold

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBars
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.SubcomposeLayout
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.offset
import com.stoyanvuchev.snoozeloo.core.presentation.ui.components.fab.utils.FloatingActionButtonUtils
import com.stoyanvuchev.snoozeloo.core.presentation.ui.theme.Theme
import com.stoyanvuchev.snoozeloo.core.presentation.ui.theme.color.LocalContentColor

@Composable
fun Scaffold(
    modifier: Modifier = Modifier,
    topBar: @Composable () -> Unit = remember { {} },
    floatingActionButton: @Composable () -> Unit = remember { {} },
    containerColor: Color = Theme.colorScheme.surface,
    contentColor: Color = Theme.colorScheme.onSurface,
    contentWindowInsets: WindowInsets = WindowInsets.systemBars,
    content: @Composable (safePadding: PaddingValues) -> Unit
) = CompositionLocalProvider(LocalContentColor provides contentColor) {

    ScaffoldLayout(
        modifier = modifier,
        topBar = topBar,
        floatingActionButton = floatingActionButton,
        containerColor = containerColor,
        contentWindowInsets = contentWindowInsets,
        content = content
    )

}

@Composable
private fun ScaffoldLayout(
    modifier: Modifier,
    topBar: @Composable () -> Unit,
    floatingActionButton: @Composable () -> Unit,
    containerColor: Color,
    contentWindowInsets: WindowInsets,
    density: Density = LocalDensity.current,
    content: @Composable (safePadding: PaddingValues) -> Unit
) = SubcomposeLayout(
    modifier = Modifier
        .fillMaxSize()
        .background(color = containerColor)
        .then(modifier)
) { constraints ->

    val layoutWidth = constraints.maxWidth
    val layoutHeight = constraints.maxHeight
    val looseConstraints = constraints.copy(
        minWidth = 0,
        minHeight = 0
    )

    layout(
        width = layoutWidth,
        height = layoutHeight
    ) {

        /*
         * Defining placeables.
         */

        // Defining the TopBar placeable.

        val topBarPlaceable = subcompose(
            slotId = ScaffoldLayoutSlots.TOP_BAR,
            content = topBar
        ).map { it.measure(constraints = looseConstraints.offset()) }

        val topBarHeight = topBarPlaceable.maxByOrNull { it.height }?.height ?: 0

        // Defining the FAB placeable.

        val fabPlaceable = subcompose(
            slotId = ScaffoldLayoutSlots.FAB,
            content = floatingActionButton
        ).map { it.measure(constraints = looseConstraints.offset()) }

        val fabWidth = fabPlaceable.maxByOrNull { it.width }?.width ?: 0
        val fabHeight = fabPlaceable.maxByOrNull { it.height }?.height ?: 0

        // Defining the Content placeable.

        val contentPlaceable = subcompose(
            slotId = ScaffoldLayoutSlots.CONTENT,
            content = {

                val insets = contentWindowInsets.asPaddingValues(this@SubcomposeLayout)
                val safePadding = PaddingValues(
                    top = insets.calculateTopPadding().plus(topBarHeight.toDp()),
                    bottom = insets.calculateBottomPadding().plus(fabHeight.toDp()),
                    start = insets.calculateStartPadding((this@SubcomposeLayout).layoutDirection),
                    end = insets.calculateEndPadding((this@SubcomposeLayout).layoutDirection)
                )

                content(safePadding)

            }
        ).map { it.measure(constraints = looseConstraints.offset()) }

        /*
         * Defining each placeables position offset.
         */

        // Defining the TopBar placeable position offset.
        val topBarPlaceableOffset = IntOffset.Zero

        // Defining the FAB placeable position offset.
        val fabPlaceableOffset = IntOffset(
            x = layoutWidth.div(2) - fabWidth.div(2),
            y = layoutHeight - fabHeight
                .plus(contentWindowInsets.getBottom(density))
                .plus(FloatingActionButtonUtils.containerSize.roundToPx().div(2))
        )

        /*
         * Placing the placeables by maintaining the layout hierarchy:
         * Content >> TopBar >> FAB
         */

        // Placing the Content placeable.
        contentPlaceable.forEach { it.place(position = IntOffset.Zero) }

        // Placing the TopBar placeable.
        topBarPlaceable.forEach { it.place(position = topBarPlaceableOffset) }

        // Placing the FAB placeable.
        fabPlaceable.forEach { it.place(position = fabPlaceableOffset) }

    }

}

private enum class ScaffoldLayoutSlots {
    CONTENT, TOP_BAR, FAB;
}