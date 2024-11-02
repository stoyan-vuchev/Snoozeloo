package com.stoyanvuchev.snoozeloo.core.presentation.ui.theme.shape

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import sv.lib.squircleshape.CornerSmoothing
import sv.lib.squircleshape.SquircleShape

@Immutable
object SnoozelooShapes : Shapes {

    // A small shape for components initiating sharp actions e.g. navigation.
    override val small: Shape
        get() = SquircleShape(
            radius = 8.dp,
            cornerSmoothing = CornerSmoothing.Small
        )

    // A medium shape for cards and other related components.
    override val medium: Shape
        get() = SquircleShape(
            radius = 16.dp,
            cornerSmoothing = CornerSmoothing.Small
        )

    // A shape large shape for interactive components e.g. buttons and switches.
    override val large: Shape
        get() = SquircleShape(
            percent = 100,
            cornerSmoothing = CornerSmoothing.Small
        )

}

@Immutable
interface Shapes {
    val small: Shape
    val medium: Shape
    val large: Shape
}

val LocalShapes = staticCompositionLocalOf<Shapes> { SnoozelooShapes }