package com.stoyanvuchev.snoozeloo.core.presentation.ui.theme

import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import assertk.assertThat
import assertk.assertions.isEqualTo
import com.stoyanvuchev.snoozeloo.core.presentation.ui.theme.color.LocalColorScheme
import com.stoyanvuchev.snoozeloo.core.presentation.ui.theme.color.SnoozelooColorScheme
import com.stoyanvuchev.snoozeloo.core.presentation.ui.theme.shape.LocalShapes
import com.stoyanvuchev.snoozeloo.core.presentation.ui.theme.shape.SnoozelooShapes
import com.stoyanvuchev.snoozeloo.core.presentation.ui.theme.typeface.LocalTypefaces
import com.stoyanvuchev.snoozeloo.core.presentation.ui.theme.typeface.SnoozelooTypefaces
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ThemeTest {

    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun colorSchemeIsProvided() = runTest {
        composeRule.setContent {

            val expected = remember { SnoozelooColorScheme }

            CompositionLocalProvider(LocalColorScheme provides expected) {

                val actual = Theme.colorScheme
                assertThat(actual).isEqualTo(expected)

            }

        }
    }

    @Test
    fun shapesAreProvided() = runTest {
        composeRule.setContent {

            val expected = remember { SnoozelooShapes }

            CompositionLocalProvider(LocalShapes provides expected) {

                val actual = Theme.shapes
                assertThat(actual).isEqualTo(expected)

            }

        }
    }

    @Test
    fun typefacesAreProvided() = runTest {
        composeRule.setContent {

            val expected = remember { SnoozelooTypefaces }

            CompositionLocalProvider(LocalTypefaces provides expected) {

                val actual = Theme.typefaces
                assertThat(actual).isEqualTo(expected)

            }

        }
    }

}