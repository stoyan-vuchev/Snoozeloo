package com.stoyanvuchev.snoozeloo.core.presentation.ui.components.card

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.unit.dp
import androidx.test.ext.junit.runners.AndroidJUnit4
import assertk.assertThat
import assertk.assertions.isTrue
import com.stoyanvuchev.snoozeloo.core.presentation.ui.theme.Theme
import com.stoyanvuchev.snoozeloo.core.presentation.ui.theme.color.LocalContentColor
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CardTest {

    @get:Rule
    val composeRule = createComposeRule()

    companion object {
        private const val CARD_TAG = "card"
    }

    @Test
    fun assertThatTheCardIsDisplayed() = runTest {

        composeRule.setContent {

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {

                Card(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .testTag(CARD_TAG),
                    onClick = {}
                ) {

                    BasicText(
                        text = "Card test",
                        style = Theme.typefaces.displayMedium.copy(
                            color = LocalContentColor.current
                        )
                    )

                }

            }

        }

        composeRule.awaitIdle()
        composeRule.onNodeWithTag(CARD_TAG)
            .assertExists()
            .assertIsDisplayed()

    }

    @Test
    fun assertThatTheCardIsClicked() = runTest {

        var clicked = false

        composeRule.setContent {

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {

                Card(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .testTag(CARD_TAG),
                    onClick = { clicked = !clicked }
                ) {

                    BasicText(
                        text = "Card test",
                        style = Theme.typefaces.displayMedium.copy(
                            color = LocalContentColor.current
                        )
                    )

                }

            }

        }

        composeRule.awaitIdle()
        composeRule.onNodeWithTag(CARD_TAG).performClick()

        composeRule.awaitIdle()
        assertThat(clicked).isTrue()

    }

}