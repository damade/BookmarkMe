package com.bookmark.bookmarkme.ui.core.foundation.util

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable

@Composable
actual fun shouldUseDarkTheme(): Boolean = isSystemInDarkTheme()

