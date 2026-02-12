package com.bookmark.bookmarkme.ui.core.foundation

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialExpressiveTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.expressiveLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import com.bookmark.bookmarkme.ui.core.components.ComposableParam
import com.bookmark.bookmarkme.ui.core.foundation.util.shouldUseDarkTheme

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
actual fun BookmarkTheme(
    useDarkTheme: Boolean?,
    content: ComposableParam,
) {
    val isDarkTheme = useDarkTheme ?: shouldUseDarkTheme()

    val colorScheme =
        when {
            isDarkTheme -> darkColorScheme(primary = Color(color = 0xFF66ffc7))
            else -> expressiveLightColorScheme()
        }

    CompositionLocalProvider(
        LocalBookmarkColors provides BookmarkColours(),
    ) {
        MaterialExpressiveTheme(colorScheme = colorScheme) {
            Box { content() }
        }
    }
}
