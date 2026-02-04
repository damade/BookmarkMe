package com.bookmark.bookmarkme.ui.core.components.spacing

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

@Composable
fun BookmarkVerticalSpacer(
    height: Dp,
) {
    Spacer(modifier = Modifier.height(height = height))
}

@Composable
fun BookmarkHorizontalSpacer(
    width: Dp,
) {
    Spacer(modifier = Modifier.width(width = width))
}

@Composable
fun RowScope.BookmarkFillSpacer() {
    Spacer(modifier = Modifier.weight(weight = 1f))
}

@Composable
fun ColumnScope.BookmarkFillSpacer() {
    Spacer(modifier = Modifier.weight(weight = 1f))
}

fun LazyListScope.verticalSpacer(height: Dp) = item { BookmarkVerticalSpacer(height = height) }

fun LazyListScope.horizontalSpacer(width: Dp) = item { BookmarkHorizontalSpacer(width = width) }
