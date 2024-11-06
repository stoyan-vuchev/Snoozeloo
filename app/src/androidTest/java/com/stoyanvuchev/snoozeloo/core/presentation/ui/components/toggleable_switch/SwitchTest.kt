package com.stoyanvuchev.snoozeloo.core.presentation.ui.components.toggleable_switch

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performTouchInput
import androidx.compose.ui.test.swipe
import androidx.test.ext.junit.runners.AndroidJUnit4
import assertk.assertThat
import assertk.assertions.isFalse
import assertk.assertions.isTrue
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SwitchTest {

    @get:Rule
    val composeRule = createComposeRule()

    companion object {
        private const val SWITCH_TEST_TAG = "switch"
    }

    @Test
    fun assertTheSwitchIsDisplayed() = runTest {

        var switched = false

        composeRule.setContent {

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {

                val isSwitched by rememberUpdatedState(switched)
                val onSwitched = remember<(Boolean) -> Unit> { { switched = it } }

                Switch(
                    modifier = Modifier.testTag(SWITCH_TEST_TAG),
                    switched = isSwitched,
                    onSwitched = onSwitched
                )

            }

        }

        composeRule.awaitIdle()
        composeRule.onNodeWithTag(SWITCH_TEST_TAG)
            .assertExists()
            .assertIsDisplayed()

    }

    @Test
    fun assertTheSwitchIsToggledOnAndOffBySwipe() = runTest {

        var switched = false

        composeRule.setContent {

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {

                val isSwitched by rememberUpdatedState(switched)
                val onSwitched = remember<(Boolean) -> Unit> { { switched = it } }

                Switch(
                    modifier = Modifier.testTag(SWITCH_TEST_TAG),
                    switched = isSwitched,
                    onSwitched = onSwitched
                )

            }

        }

        composeRule.awaitIdle()
        composeRule.onNodeWithTag(SWITCH_TEST_TAG)
            .performTouchInput {
                this.swipe(
                    start = this.centerLeft,
                    end = this.centerRight
                )
            }

        composeRule.awaitIdle()
        assertThat(switched).isTrue()

        composeRule.awaitIdle()
        composeRule.onNodeWithTag(SWITCH_TEST_TAG)
            .performTouchInput {
                this.swipe(
                    start = this.centerRight,
                    end = this.centerLeft
                )
            }

        composeRule.awaitIdle()
        assertThat(switched).isFalse()

    }

}