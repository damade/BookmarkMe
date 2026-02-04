package com.bookmark.bookmarkme.ui.core.foundation

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialExpressiveTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.expressiveLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import com.bookmark.bookmarkme.ui.core.components.ComposableParam
import com.bookmark.bookmarkme.ui.core.components.StatusBarSideEffect
import com.bookmark.bookmarkme.ui.core.foundation.util.shouldUseDarkTheme

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
actual fun BookmarkTheme(
    androidStatusBarSideEffect: StatusBarSideEffect?,
    useDarkTheme: Boolean?,
    content: ComposableParam,
) {
    val isDarkTheme = useDarkTheme ?: shouldUseDarkTheme()

    val darkColorScheme = darkColorScheme(primary = Color(color = 0xFF66ffc7))

    val colorScheme = when {
        isDarkTheme -> darkColorScheme
        else -> expressiveLightColorScheme()
    }

    androidStatusBarSideEffect?.let {
        it(colorScheme.secondary.toArgb(), isDarkTheme)
    }

    MaterialExpressiveTheme(colorScheme = colorScheme) {
        Box { content() }
    }
}
