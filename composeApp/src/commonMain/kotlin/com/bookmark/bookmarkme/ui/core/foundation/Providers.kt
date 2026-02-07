package com.bookmark.bookmarkme.ui.core.foundation

import androidx.compose.runtime.staticCompositionLocalOf

internal val LocalBookmarkColors =
    staticCompositionLocalOf<BookmarkColours> {
        error("No BookmarkColours provided.")
    }
