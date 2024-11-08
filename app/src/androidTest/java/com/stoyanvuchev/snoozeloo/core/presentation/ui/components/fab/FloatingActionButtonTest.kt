package com.stoyanvuchev.snoozeloo.core.presentation.ui.components.fab

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import assertk.assertThat
import assertk.assertions.isTrue
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FloatingActionButtonTest {

    @get:Rule
    val composeRule = createComposeRule()

    companion object {
        private const val FAB_TAG = "fab"
        private const val FAB_CONTENT_TAG = "fabContent"
    }

    @Test
    fun assertTheFABIsDisplayed() = runTest {

        composeRule.setContent {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {

                FloatingActionButton(
                    modifier = Modifier.testTag(FAB_TAG),
                    onClick = {}
                )

            }
        }

        composeRule.awaitIdle()
        composeRule.onNodeWithTag(FAB_TAG)
            .assertExists()
            .assertIsDisplayed()

    }

    @Test
    fun assertTheFABContentIsDisplayed() = runTest {

        composeRule.setContent {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {

                FloatingActionButton(
                    modifier = Modifier.testTag(FAB_TAG),
                    onClick = {}
                ) {

                    DefaultFloatingActionButtonContent(
                        modifier = Modifier.testTag(FAB_CONTENT_TAG)
                    )

                }

            }
        }

        composeRule.awaitIdle()
        composeRule.onNodeWithTag(FAB_CONTENT_TAG, useUnmergedTree = true)
            .assertExists()
            .assertIsDisplayed()

    }

    @Test
    fun assertTheFABIsClicked() = runTest {

        var clicked = false

        composeRule.setContent {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {

                FloatingActionButton(
                    modifier = Modifier.testTag(FAB_TAG),
                    onClick = { clicked = !clicked }
                )

            }
        }

        composeRule.awaitIdle()
        composeRule.onNodeWithTag(FAB_TAG)
            .performClick()

        composeRule.awaitIdle()
        assertThat(clicked).isTrue()

    }

}