package com.stoyanvuchev.snoozeloo.core.presentation.ui.theme.typeface

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
class SnoozelooTypefacesTest {

    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun typefacesAreProvided() = runTest {
        composeRule.setContent {

            val expected = remember { SnoozelooTypefaces }

            CompositionLocalProvider(LocalTypefaces provides expected) {

                val actual = LocalTypefaces.current
                assertThat(actual).isEqualTo(expected)

            }

        }
    }

    @Test
    fun textStyleIsProvided() = runTest {
        composeRule.setContent {

            val expected = remember { SnoozelooTypefaces.bodyLarge }

            CompositionLocalProvider(LocalTextStyle provides expected) {

                val actual = LocalTextStyle.current
                assertThat(actual).isEqualTo(expected)

            }

        }
    }

}