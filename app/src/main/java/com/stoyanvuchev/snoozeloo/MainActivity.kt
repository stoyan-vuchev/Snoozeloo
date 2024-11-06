package com.stoyanvuchev.snoozeloo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stoyanvuchev.snoozeloo.core.presentation.ui.components.topbar.TopBar
import com.stoyanvuchev.snoozeloo.core.presentation.ui.components.topbar.TopBarTitle
import com.stoyanvuchev.snoozeloo.core.presentation.ui.theme.SnoozelooTheme
import com.stoyanvuchev.snoozeloo.core.presentation.ui.theme.Theme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            SnoozelooTheme {

                Greeting(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Theme.colorScheme.surface)
                )

            }
        }

    }

}

@Composable
fun Greeting(
    name: String = stringResource(id = R.string.app_name),
    modifier: Modifier = Modifier.fillMaxSize()
) = Box(
    modifier = modifier,
    contentAlignment = Alignment.Center
) {

    BasicText(
        modifier = Modifier
            .systemBarsPadding()
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .clip(Theme.shapes.medium)
            .background(Theme.colorScheme.surfaceContainer)
            .padding(16.dp),
        text = "Hello $name!",
        style = Theme.typefaces.labelMedium.copy(
            color = Theme.colorScheme.onSurfaceContainer
        )
    )

    TopBar(
        modifier = Modifier.align(Alignment.TopStart),
        title = { TopBarTitle(text = "Your Alarms") }
    )

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SnoozelooTheme {
        Greeting()
    }
}