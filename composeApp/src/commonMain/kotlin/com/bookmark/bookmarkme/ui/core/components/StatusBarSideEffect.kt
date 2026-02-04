package com.bookmark.bookmarkme.ui.core.components

import androidx.compose.runtime.Composable

typealias StatusBarSideEffect = @Composable ((statusBarColor: Int, isDarkTheme: Boolean) -> Unit)
