package com.stoyanvuchev.snoozeloo.core.presentation.ui.components.topbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.SubcomposeLayout
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.LayoutDirection
import com.stoyanvuchev.snoozeloo.core.presentation.ui.components.topbar.util.TopBarUtils
import com.stoyanvuchev.snoozeloo.core.presentation.ui.theme.Theme
import com.stoyanvuchev.snoozeloo.core.presentation.ui.theme.color.LocalContentColor
import com.stoyanvuchev.snoozeloo.core.presentation.ui.theme.typeface.LocalTextStyle

@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    title: @Composable () -> Unit,
    navButton: @Composable (() -> Unit)? = null,
    actionButton: @Composable (() -> Unit)? = null
) = CompositionLocalProvider(
    LocalContentColor provides Theme.colorScheme.onSurface,
    LocalTextStyle provides Theme.typefaces.displaySmall,
    content = {

        TopBarLayout(
            modifier = modifier,
            title = title,
            navButton = navButton,
            actionButton = actionButton
        )

    }
)

@Composable
private fun TopBarLayout(
    modifier: Modifier,
    title: @Composable () -> Unit,
    navButton: @Composable (() -> Unit)?,
    actionButton: @Composable (() -> Unit)?,
    windowInsets: WindowInsets = TopBarUtils.windowInsets()
) {

    val density = LocalDensity.current
    val contentContainerHeight = remember { TopBarUtils.containerHeight }

    val statusBarHeight: Dp
    val topBarHeight: Dp

    density.run {
        statusBarHeight = windowInsets.getTop(this).toDp()
        topBarHeight = contentContainerHeight + statusBarHeight
    }

    SubcomposeLayout(
        modifier = Modifier
            .height(topBarHeight)
            .background(color = Theme.colorScheme.surface)
            .then(modifier),
    ) { constraints ->

        val layoutWidth = constraints.maxWidth
        val layoutHeight = constraints.maxHeight
        val looseConstraints = constraints.copy(
            minWidth = 0,
            minHeight = 0
        )

        val layoutDirection = this.layoutDirection
        val contentPadding = TopBarUtils.contentPadding.roundToPx()
        val safeContentHeight = layoutHeight.minus(contentPadding * 2)

        layout(
            width = layoutWidth,
            height = layoutHeight
        ) {

            /*
             * Placeables
             */

            // Defining NavButton placeable.

            val navButtonPlaceable = subcompose(
                slotId = TopBarLayoutSlots.NAV_BUTTON,
                content = navButton ?: {}
            ).map { it.measure(looseConstraints) }

            val navButtonWidth = navButtonPlaceable
                .maxByOrNull { it.width }?.width ?: 0

            val navButtonHeight = navButtonPlaceable
                .maxByOrNull { it.height.coerceAtMost(safeContentHeight) }
                ?.height ?: 0

            // Defining ActionButton placeable.

            val actionButtonPlaceable = subcompose(
                slotId = TopBarLayoutSlots.ACTION_BUTTON,
                content = actionButton ?: {}
            ).map { it.measure(looseConstraints) }

            val actionButtonWidth = actionButtonPlaceable
                .maxByOrNull { it.width }?.width ?: 0

            val actionButtonHeight = actionButtonPlaceable
                .maxByOrNull { it.height.coerceAtMost(safeContentHeight) }
                ?.height ?: 0

            // Defining Title placeable.

            val titlePlaceable = subcompose(
                slotId = TopBarLayoutSlots.TITLE,
                content = title
            ).map { it.measure(looseConstraints) }

            val titleHorizontalPadding = TopBarUtils.titleHorizontalPadding.roundToPx()
            val safeTitleWidth = layoutWidth
                .minus(actionButtonWidth)
                .minus(navButtonWidth)
                .minus(contentPadding * 2)
                .minus(titleHorizontalPadding * 2)

            val titleWidth = titlePlaceable
                .maxByOrNull { it.width.coerceAtMost(safeTitleWidth) }
                ?.width ?: 0

            val titleHeight = titlePlaceable
                .maxByOrNull { it.height.coerceAtMost(safeContentHeight) }
                ?.height ?: 0

            /*
             * Position Offset
             */

            // Defining the NavButton position offset.

            val navButtonPositionOffset = IntOffset(
                x = if (layoutDirection == LayoutDirection.Ltr) contentPadding
                else layoutWidth - contentPadding,
                y = (layoutHeight.div(2) - navButtonHeight.div(2))
                    .plus(statusBarHeight.roundToPx().div(2))

            )

            // Defining the ActionButton position offset.

            val actionButtonPositionOffset = IntOffset(
                x = if (layoutDirection != LayoutDirection.Ltr) contentPadding
                else layoutWidth - actionButtonWidth.plus(contentPadding),
                y = (layoutHeight.div(2) - actionButtonHeight.div(2))
                    .plus(statusBarHeight.roundToPx().div(2))
            )

            // Defining the Title position offset.

            val titlePositionOffset = IntOffset(
                x = if (layoutDirection == LayoutDirection.Ltr) {
                    navButtonWidth
                        .plus(contentPadding)
                        .plus(titleHorizontalPadding)
                } else {
                    layoutWidth.minus(
                        navButtonWidth
                            .plus(contentPadding)
                            .plus(titleHorizontalPadding)
                            .plus(titleWidth)
                    )
                },
                y = (layoutHeight.div(2) - titleHeight.div(2))
                    .plus(statusBarHeight.roundToPx().div(2))
            )

            /*
             * Placing the content.
             */

            // Placing the NavButton.

            navButtonPlaceable.forEach { it.place(navButtonPositionOffset) }

            // Placing the Title.

            titlePlaceable.forEach { it.place(titlePositionOffset) }

            // Placing the ActionButton.

            actionButtonPlaceable.forEach { it.place(actionButtonPositionOffset) }

        }

    }
}

private enum class TopBarLayoutSlots {
    NAV_BUTTON, TITLE, ACTION_BUTTON;
}