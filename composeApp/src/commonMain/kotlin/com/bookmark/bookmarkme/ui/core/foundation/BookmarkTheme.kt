package com.bookmark.bookmarkme.ui.core.foundation

import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.bookmark.bookmarkme.ui.core.components.ComposableParam
import com.bookmark.bookmarkme.ui.core.components.StatusBarSideEffect

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
expect fun BookmarkTheme(
    androidStatusBarSideEffect: StatusBarSideEffect? = null,
    useDarkTheme: Boolean? = null,
    content: ComposableParam,
)

@Composable
fun BookmarkPreviewTheme(
    content: ComposableParam,
) {
    BookmarkTheme {
        Surface(content = content)
    }
}
