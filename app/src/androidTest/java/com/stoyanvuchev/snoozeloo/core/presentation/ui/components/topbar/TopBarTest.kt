package com.stoyanvuchev.snoozeloo.core.presentation.ui.components.topbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicText
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.unit.dp
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.stoyanvuchev.snoozeloo.core.presentation.ui.theme.Theme
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TopBarTest {

    @get:Rule
    val composeRule = createComposeRule()

    companion object {
        private const val TOP_BAR_TEST_TAG = "topBar"
        private const val TOP_BAR_TITLE_TEST_TAG = "topBarTitle"
        private const val TOP_BAR_NAV_BUTTON_TEST_TAG = "topBarNavButton"
        private const val TOP_BAR_ACTION_BUTTON_TEST_TAG = "topBarActionButton"
    }

    @Test
    fun assertTheTopBarIsDisplayed() = runTest {

        composeRule.setContent {

            Box(
                modifier = Modifier.fillMaxSize()
            ) {

                TopBar(
                    modifier = Modifier.testTag(TOP_BAR_TEST_TAG),
                    title = { TopBarTitle(text = "Top Bar") }
                )

            }

        }

        composeRule.awaitIdle()
        composeRule.onNodeWithTag(TOP_BAR_TEST_TAG)
            .assertExists()
            .assertIsDisplayed()

    }

    @Test
    fun assertTheTopBarTitleIsDisplayed() = runTest {

        composeRule.setContent {

            Box(
                modifier = Modifier.fillMaxSize()
            ) {

                TopBar(
                    title = {

                        TopBarTitle(
                            modifier = Modifier.testTag(TOP_BAR_TITLE_TEST_TAG),
                            text = "Top Bar"
                        )

                    }
                )

            }

        }

        composeRule.awaitIdle()
        composeRule.onNodeWithTag(TOP_BAR_TITLE_TEST_TAG)
            .assertExists()
            .assertIsDisplayed()

    }

    @Test
    fun assertTheTopBarNavButtonIsDisplayed() = runTest {

        composeRule.setContent {

            Box(
                modifier = Modifier.fillMaxSize()
            ) {

                TopBar(
                    title = {},
                    navButton = {

                        Box(
                            modifier = Modifier
                                .size(48.dp)
                                .testTag(TOP_BAR_NAV_BUTTON_TEST_TAG),
                            contentAlignment = Alignment.Center
                        ) {

                            Box(
                                modifier = Modifier
                                    .size(32.dp)
                                    .clip(Theme.shapes.small)
                                    .background(Theme.colorScheme.primary)
                            )

                        }

                    }
                )

            }

        }

        composeRule.awaitIdle()
        composeRule.onNodeWithTag(TOP_BAR_NAV_BUTTON_TEST_TAG)
            .assertExists()
            .assertIsDisplayed()

    }

    @Test
    fun assertTheTopBarActionButtonIsDisplayed() = runTest {

        composeRule.setContent {

            Box(
                modifier = Modifier.fillMaxSize()
            ) {

                TopBar(
                    title = {},
                    actionButton = {

                        Box(
                            modifier = Modifier
                                .height(48.dp)
                                .padding(horizontal = 8.dp)
                                .testTag(TOP_BAR_ACTION_BUTTON_TEST_TAG),
                            contentAlignment = Alignment.Center
                        ) {

                            Box(
                                modifier = Modifier
                                    .height(32.dp)
                                    .clip(Theme.shapes.large)
                                    .background(Theme.colorScheme.primary)
                                    .padding(horizontal = 16.dp),
                                contentAlignment = Alignment.Center
                            ) {

                                BasicText(
                                    text = "Save",
                                    style = Theme.typefaces.labelMedium.copy(
                                        color = Theme.colorScheme.onPrimary
                                    )
                                )

                            }

                        }

                    }
                )

            }

        }

        composeRule.awaitIdle()
        composeRule.onNodeWithTag(TOP_BAR_ACTION_BUTTON_TEST_TAG)
            .assertExists()
            .assertIsDisplayed()

    }

    @Test
    fun assertAllTheTopBarComponentsAreDisplayed() = runTest {

        composeRule.setContent {

            Box(
                modifier = Modifier.fillMaxSize()
            ) {

                TopBar(
                    title = {

                        TopBarTitle(
                            modifier = Modifier.testTag(TOP_BAR_TITLE_TEST_TAG),
                            text = "Top Bar"
                        )

                    },
                    navButton = {

                        Box(
                            modifier = Modifier
                                .size(48.dp)
                                .testTag(TOP_BAR_NAV_BUTTON_TEST_TAG),
                            contentAlignment = Alignment.Center
                        ) {

                            Box(
                                modifier = Modifier
                                    .size(32.dp)
                                    .clip(Theme.shapes.small)
                                    .background(Theme.colorScheme.primary)
                            )

                        }

                    },
                    actionButton = {

                        Box(
                            modifier = Modifier
                                .height(48.dp)
                                .padding(horizontal = 8.dp)
                                .testTag(TOP_BAR_ACTION_BUTTON_TEST_TAG),
                            contentAlignment = Alignment.Center
                        ) {

                            Box(
                                modifier = Modifier
                                    .height(32.dp)
                                    .clip(Theme.shapes.large)
                                    .background(Theme.colorScheme.primary)
                                    .padding(horizontal = 16.dp),
                                contentAlignment = Alignment.Center
                            ) {

                                BasicText(
                                    text = "Save",
                                    style = Theme.typefaces.labelMedium.copy(
                                        color = Theme.colorScheme.onPrimary
                                    )
                                )

                            }

                        }

                    }
                )

            }

        }

        composeRule.awaitIdle()
        composeRule.onNodeWithTag(TOP_BAR_TITLE_TEST_TAG)
            .assertExists()
            .assertIsDisplayed()

        composeRule.awaitIdle()
        composeRule.onNodeWithTag(TOP_BAR_NAV_BUTTON_TEST_TAG)
            .assertExists()
            .assertIsDisplayed()

        composeRule.awaitIdle()
        composeRule.onNodeWithTag(TOP_BAR_ACTION_BUTTON_TEST_TAG)
            .assertExists()
            .assertIsDisplayed()

    }

}