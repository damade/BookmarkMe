package com.bookmark.bookmarkme.ui.core.foundation

import android.os.Build
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialExpressiveTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalContext
import com.bookmark.bookmarkme.ui.core.components.ComposableParam
import com.bookmark.bookmarkme.ui.core.foundation.util.shouldUseDarkTheme

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
actual fun BookmarkTheme(
    useDarkTheme: Boolean?,
    content: ComposableParam,
) {
    val isDarkTheme = useDarkTheme ?: shouldUseDarkTheme()
    val supportsDynamicColor = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S

    val colorScheme =
        when {
            supportsDynamicColor && isDarkTheme -> {
                dynamicDarkColorScheme(context = LocalContext.current)
            }

            supportsDynamicColor && !isDarkTheme -> {
                dynamicLightColorScheme(context = LocalContext.current)
            }

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
