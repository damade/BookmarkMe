package com.bookmark.bookmarkme.ui.core.foundation

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialExpressiveTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.bookmark.bookmarkme.ui.core.components.ComposableParam

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
actual fun BookmarkTheme(
    useDarkTheme: Boolean?,
    content: ComposableParam,
) {
    // val isDarkTheme = useDarkTheme ?: shouldUseDarkTheme()
    val isDarkTheme = false

    val colorScheme =
        when {
            isDarkTheme -> bookmarkDarkColourScheme
            else -> bookmarkExpressiveLightColourScheme
        }

    CompositionLocalProvider(
        LocalBookmarkColors provides BookmarkColours(),
    ) {
        MaterialExpressiveTheme(colorScheme = colorScheme) {
            Box { content() }
        }
    }
}
