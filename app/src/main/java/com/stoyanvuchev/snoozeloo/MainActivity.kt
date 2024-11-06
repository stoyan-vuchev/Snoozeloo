package com.stoyanvuchev.snoozeloo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.stoyanvuchev.snoozeloo.core.presentation.ui.components.toggleable_switch.Switch
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
    modifier: Modifier = Modifier.fillMaxSize()
) = Box(
    modifier = modifier,
    contentAlignment = Alignment.Center
) {

    var switched by rememberSaveable { mutableStateOf(false) }

    Switch(
        switched = switched,
        onSwitched = { switched = it }
    )

    TopBar(
        modifier = Modifier.align(Alignment.TopStart),
        title = { TopBarTitle(text = stringResource(id = R.string.app_name)) }
    )

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SnoozelooTheme {
        Greeting()
    }
}