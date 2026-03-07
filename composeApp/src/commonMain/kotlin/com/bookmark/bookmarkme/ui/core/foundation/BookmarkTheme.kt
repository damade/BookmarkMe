package com.bookmark.bookmarkme.ui.core.foundation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bookmark.bookmarkme.ui.core.components.ComposableParam
import com.bookmark.bookmarkme.ui.core.components.modifiers.conditional

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
expect fun BookmarkTheme(
    useDarkTheme: Boolean? = null,
    content: ComposableParam,
)

@Composable
fun BookmarkPreviewTheme(
    width: PreviewWidth = PreviewWidth.Compact,
    content: ComposableParam,
) {
    BookmarkTheme {
        Box(
            modifier =
                Modifier.conditional(
                    condition = width == PreviewWidth.Full,
                    ifTrue = { fillMaxSize() },
                ),
        ) {
            Surface(content = content)
        }
    }
}

enum class PreviewWidth {
    Compact,
    Full,
}

object BookmarkTheme {
    val colors: BookmarkColours
        @Composable
        get() = LocalBookmarkColors.current
}
