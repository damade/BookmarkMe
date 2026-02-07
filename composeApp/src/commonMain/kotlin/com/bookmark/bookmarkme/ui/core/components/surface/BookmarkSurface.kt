package com.bookmark.bookmarkme.ui.core.components.surface

import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.LocalMinimumInteractiveComponentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun BookmarkSurface(
    modifier: Modifier = Modifier,
    shape: Shape = RectangleShape,
    containerColor: Color = MaterialTheme.colorScheme.surface,
    contentColor: Color = MaterialTheme.colorScheme.onSurface,
    border: BorderStroke? = null,
    shadowElevation: Dp = 0.dp,
    content: @Composable () -> Unit,
) {
    Surface(
        modifier = modifier,
        contentColor = contentColor,
        color = containerColor,
        content = content,
        shape = shape,
        border = border,
        shadowElevation = shadowElevation,
    )
}

@Composable
fun BookmarkSurface(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = RectangleShape,
    containerColor: Color = MaterialTheme.colorScheme.surface,
    contentColor: Color = MaterialTheme.colorScheme.onSurface,
    border: BorderStroke? = null,
    minimumInteractiveSize: Dp = 48.dp,
    shadowElevation: Dp = 0.dp,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(LocalMinimumInteractiveComponentSize provides minimumInteractiveSize) {
        Surface(
            modifier = modifier,
            contentColor = contentColor,
            color = containerColor,
            content = content,
            shape = shape,
            enabled = enabled,
            onClick = onClick,
            border = border,
            shadowElevation = shadowElevation,
        )
    }
}
