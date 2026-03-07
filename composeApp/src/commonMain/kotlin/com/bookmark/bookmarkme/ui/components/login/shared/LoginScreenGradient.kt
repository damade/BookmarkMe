package com.bookmark.bookmarkme.ui.components.login.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush

@Composable
internal fun LoginScreenGradient(
    firstGradient: Brush,
    secondGradient: Brush,
) {
    Box(
        modifier =
            Modifier
                .fillMaxSize()
                .background(brush = firstGradient),
    )
    Box(
        modifier =
            Modifier
                .fillMaxSize()
                .background(brush = secondGradient),
    )
}
