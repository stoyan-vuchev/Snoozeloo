package com.stoyanvuchev.snoozeloo.core.presentation.ui.components.fab

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import com.stoyanvuchev.snoozeloo.R
import com.stoyanvuchev.snoozeloo.core.presentation.ui.components.fab.utils.FloatingActionButtonUtils
import com.stoyanvuchev.snoozeloo.core.presentation.ui.theme.Theme

@Composable
fun DefaultFloatingActionButtonContent(
    modifier: Modifier = Modifier
) {

    Image(
        modifier = Modifier
            .size(FloatingActionButtonUtils.contentSize)
            .then(modifier),
        painter = painterResource(id = R.drawable.round_add_24),
        colorFilter = ColorFilter.tint(color = Theme.colorScheme.onPrimary),
        contentDescription = null
    )

}