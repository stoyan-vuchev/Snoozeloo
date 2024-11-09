package com.stoyanvuchev.snoozeloo.core.presentation.ui.components.layout.scaffold

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import assertk.assertThat
import assertk.assertions.isTrue
import com.stoyanvuchev.snoozeloo.core.presentation.ui.components.fab.FloatingActionButton
import com.stoyanvuchev.snoozeloo.core.presentation.ui.components.topbar.TopBar
import com.stoyanvuchev.snoozeloo.core.presentation.ui.components.topbar.TopBarTitle
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ScaffoldTest {

    @get:Rule
    val composeRule = createComposeRule()

    companion object {
        private const val SCAFFOLD_TAG = "scaffold"
        private const val TOP_BAR_TAG = "topBar"
        private const val FAB_TAG = "fab"
        private const val CONTENT_TAG = "content"
    }

    @Test
    fun assertThatTheScaffoldIsDisplayed() = runTest {

        composeRule.setContent {
            Scaffold(
                modifier = Modifier.testTag(SCAFFOLD_TAG),
                content = { _ -> }
            )
        }

        composeRule.awaitIdle()
        composeRule.onNodeWithTag(SCAFFOLD_TAG)
            .assertExists()
            .assertIsDisplayed()

    }

    @Test
    fun assertThatTheScaffoldTopBarIsDisplayed() = runTest {

        composeRule.setContent {
            Scaffold(
                modifier = Modifier.testTag(SCAFFOLD_TAG),
                topBar = {

                    TopBar(
                        modifier = Modifier.testTag(TOP_BAR_TAG),
                        title = { TopBarTitle(text = "Scaffold Test") }
                    )

                },
                content = { _ -> }
            )
        }

        composeRule.awaitIdle()
        composeRule.onNodeWithTag(TOP_BAR_TAG)
            .assertExists()
            .assertIsDisplayed()

    }

    @Test
    fun assertThatTheScaffoldFABIsDisplayed() = runTest {

        composeRule.setContent {
            Scaffold(
                modifier = Modifier.testTag(SCAFFOLD_TAG),
                floatingActionButton = {

                    FloatingActionButton(
                        modifier = Modifier.testTag(FAB_TAG),
                        onClick = {}
                    )

                },
                content = { _ -> }
            )
        }

        composeRule.awaitIdle()
        composeRule.onNodeWithTag(FAB_TAG)
            .assertExists()
            .assertIsDisplayed()

    }

    @Test
    fun assertThatTheScaffoldFABIsClicked() = runTest {

        var clicked = false

        composeRule.setContent {
            Scaffold(
                modifier = Modifier.testTag(SCAFFOLD_TAG),
                floatingActionButton = {

                    FloatingActionButton(
                        modifier = Modifier.testTag(FAB_TAG),
                        onClick = { clicked = !clicked }
                    )

                },
                content = { _ -> }
            )
        }

        composeRule.awaitIdle()
        composeRule.onNodeWithTag(FAB_TAG).performClick()

        composeRule.awaitIdle()
        assertThat(clicked).isTrue()

    }

    @Test
    fun assertThatTheScaffoldContentIsDisplayed() = runTest {

        composeRule.setContent {
            Scaffold(
                modifier = Modifier.testTag(SCAFFOLD_TAG),
                content = { safePadding ->

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(safePadding)
                            .testTag(CONTENT_TAG)
                    )

                }
            )
        }

        composeRule.awaitIdle()
        composeRule.onNodeWithTag(CONTENT_TAG)
            .assertExists()
            .assertIsDisplayed()

    }

}