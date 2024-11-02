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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stoyanvuchev.snoozeloo.core.presentation.ui.theme.SnoozelooTheme
import com.stoyanvuchev.snoozeloo.core.presentation.ui.theme.color.LocalColorScheme
import com.stoyanvuchev.snoozeloo.core.presentation.ui.theme.shape.LocalShapes

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            SnoozelooTheme {

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = LocalColorScheme.current.surface,
                    contentColor = LocalColorScheme.current.onSurface
                ) { innerPadding ->

                    Greeting(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    )

                }

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

    Text(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .clip(LocalShapes.current.medium)
            .background(LocalColorScheme.current.surfaceContainer)
            .padding(16.dp),
        text = "Hello $name!",
        style = MaterialTheme.typography.titleMedium,
        color = LocalColorScheme.current.onSurfaceContainer
    )

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SnoozelooTheme {
        Greeting()
    }
}