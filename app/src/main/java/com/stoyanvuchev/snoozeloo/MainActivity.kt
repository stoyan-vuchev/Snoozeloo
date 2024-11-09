package com.stoyanvuchev.snoozeloo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stoyanvuchev.snoozeloo.core.presentation.ui.components.card.Card
import com.stoyanvuchev.snoozeloo.core.presentation.ui.components.fab.FloatingActionButton
import com.stoyanvuchev.snoozeloo.core.presentation.ui.components.layout.scaffold.Scaffold
import com.stoyanvuchev.snoozeloo.core.presentation.ui.components.topbar.TopBar
import com.stoyanvuchev.snoozeloo.core.presentation.ui.components.topbar.TopBarTitle
import com.stoyanvuchev.snoozeloo.core.presentation.ui.theme.SnoozelooTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            SnoozelooTheme { Greeting() }
        }

    }

}

@Composable
fun Greeting() {

    Scaffold(
        topBar = {

            TopBar(
                title = {

                    TopBarTitle(text = stringResource(id = R.string.app_name))

                }
            )

        },
        floatingActionButton = {

            FloatingActionButton(
                onClick = {}
            )

        }
    ) { safePadding ->

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = safePadding
        ) {

            item { Spacer(modifier = Modifier.height(8.dp)) }

            items(count = 100) {

                Card(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    onClick = {}
                ) {

                    Spacer(modifier = Modifier.height(200.dp))

                }

            }

        }

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SnoozelooTheme {
        Greeting()
    }
}