package com.stoyanvuchev.snoozeloo.core.presentation.ui.theme.color

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
class SnoozelooColorSchemeTest {

    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun colorSchemeIsProvided() = runTest {
        composeRule.setContent {

            val expected = remember { SnoozelooColorScheme }

            CompositionLocalProvider(LocalColorScheme provides expected) {

                val actual = LocalColorScheme.current
                assertThat(actual).isEqualTo(expected)

            }

        }
    }

    @Test
    fun contentColorIsProvided() = runTest {
        composeRule.setContent {

            val expected = remember { SnoozelooColorScheme.onSurface }

            CompositionLocalProvider(LocalContentColor provides expected) {

                val actual = LocalContentColor.current
                assertThat(actual).isEqualTo(expected)

            }

        }
    }

}