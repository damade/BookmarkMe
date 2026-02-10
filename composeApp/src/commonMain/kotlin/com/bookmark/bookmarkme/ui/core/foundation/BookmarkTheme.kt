package com.bookmark.bookmarkme.ui.core.foundation

import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.bookmark.bookmarkme.ui.core.components.ComposableParam

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
expect fun BookmarkTheme(
    useDarkTheme: Boolean? = null,
    content: ComposableParam,
)

@Composable
fun BookmarkPreviewTheme(content: ComposableParam) {
    BookmarkTheme {
        Surface(content = content)
    }
}

object BookmarkTheme {
    val colors: BookmarkColours
        @Composable
        get() = LocalBookmarkColors.current
}
