package com.stoyanvuchev.snoozeloo.core.presentation.ui.theme.shape

import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import assertk.assertThat
import assertk.assertions.isEqualTo
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SnoozelooShapesTest {

    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun shapesAreProvided() = runTest {
        composeRule.setContent {

            val expected = remember { SnoozelooShapes }

            CompositionLocalProvider(LocalShapes provides expected) {

                val actual = LocalShapes.current
                assertThat(actual).isEqualTo(expected)

            }

        }
    }

}