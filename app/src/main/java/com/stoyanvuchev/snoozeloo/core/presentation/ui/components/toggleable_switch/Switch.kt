package com.stoyanvuchev.snoozeloo.core.presentation.ui.components.toggleable_switch

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.stoyanvuchev.snoozeloo.core.presentation.ui.components.toggleable_switch.util.SwitchUtils

@Composable
fun Switch(
    modifier: Modifier = Modifier,
    switched: Boolean,
    onSwitched: (Boolean) -> Unit,
    colors: SwitchColors = SwitchUtils.switchColors(),
    containerShape: Shape = SwitchUtils.containerShape
) {

    SwitchLayout(
        modifier = modifier,
        switched = switched,
        onSwitched = onSwitched,
        colors = colors,
        containerShape = containerShape
    )

}

@Composable
private fun SwitchLayout(
    modifier: Modifier,
    switched: Boolean,
    onSwitched: (Boolean) -> Unit,
    colors: SwitchColors,
    containerShape: Shape,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
) {

    val layoutDirection = LocalLayoutDirection.current
    val containerSize = remember { SwitchUtils.switchContainerSize }
    val toggleRadius = remember { SwitchUtils.switchToggleRadius }

    val max = remember { containerSize.width - toggleRadius.plus(2.dp) }
    val min = remember { toggleRadius + 2.dp }

    val (minPx, maxPx) = with(LocalDensity.current) { min.toPx() to max.toPx() }
    var offsetPosition by remember(switched) {
        mutableFloatStateOf(
            if (layoutDirection == LayoutDirection.Ltr) {
                if (switched) maxPx else minPx
            } else if (switched) minPx else maxPx
        )
    }

    val backgroundColor by animateColorAsState(
        targetValue = colors.backgroundColor(switched).value,
        label = ""
    )

    val toggleColor by animateColorAsState(
        targetValue = colors.toggleColor(switched).value,
        label = ""
    )

    val toggleCenterOffsetX by animateFloatAsState(
        targetValue = offsetPosition,
        animationSpec = remember {
            spring(
                dampingRatio = Spring.DampingRatioNoBouncy,
                stiffness = Spring.StiffnessMedium
            )
        },
        label = ""
    )

    val toggleScale by animateFloatAsState(
        targetValue = when (toggleCenterOffsetX) {

            minPx -> if (layoutDirection == LayoutDirection.Ltr) {
                if (!switched) 1f else .75f
            } else {
                if (switched) 1f else .75f
            }

            maxPx -> if (layoutDirection == LayoutDirection.Ltr) {
                if (!switched) .75f else 1f
            } else {
                if (switched) .75f else 1f
            }

            else -> .75f

        },
        animationSpec = remember {
            spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = Spring.StiffnessMediumLow
            )
        },
        label = ""
    )

    Canvas(
        modifier = Modifier
            .size(size = containerSize)
            .clip(containerShape)
            .background(backgroundColor)
            .draggable(
                orientation = Orientation.Horizontal,
                state = rememberDraggableState { delta ->
                    val newValue = offsetPosition + delta
                    offsetPosition = newValue.coerceIn(minPx, maxPx)
                },
                onDragStopped = { _ ->
                    offsetPosition = if (offsetPosition >= maxPx.div(2)) maxPx else minPx
                    onSwitched(
                        offsetPosition == if (layoutDirection == LayoutDirection.Ltr) maxPx
                        else minPx
                    )
                },
                interactionSource = interactionSource
            )
            .clickable(
                onClick = { onSwitched(!switched) },
                interactionSource = interactionSource,
                indication = null
            )
            .then(modifier)
    ) {

        drawCircle(
            color = toggleColor,
            radius = toggleRadius.toPx() * toggleScale,
            center = Offset(
                x = toggleCenterOffsetX,
                y = this.center.y
            )
        )

    }

}