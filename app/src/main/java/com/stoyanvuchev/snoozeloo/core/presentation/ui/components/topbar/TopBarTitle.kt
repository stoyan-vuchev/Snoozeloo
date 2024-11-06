package com.stoyanvuchev.snoozeloo.core.presentation.ui.components.topbar

import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import com.stoyanvuchev.snoozeloo.core.presentation.ui.theme.color.LocalContentColor
import com.stoyanvuchev.snoozeloo.core.presentation.ui.theme.typeface.LocalTextStyle

@Composable
fun TopBarTitle(
    modifier: Modifier = Modifier,
    text: String
) = BasicText(
    modifier = modifier,
    text = text,
    overflow = TextOverflow.Ellipsis,
    maxLines = 2,
    style = LocalTextStyle.current.copy(
        color = LocalContentColor.current
    )
)