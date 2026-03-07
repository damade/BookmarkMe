package com.bookmark.bookmarkme.ui.components.login.shared

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

// Gradient 1: "to top" means bottom → top (reversed in Compose)
val gradient1Brush =
    Brush.verticalGradient(
        colorStops =
            arrayOf(
                0.0f to Color(0xFF377CED),
                0.5f to Color(0xBF245A8D),
                1.0f to Color(0x00070917),
            ),
        startY = Float.POSITIVE_INFINITY, // bottom
        endY = 0f, // top
    )

val gradient2Brush =
    Brush.verticalGradient(
        colorStops =
            arrayOf(
                0.0f to Color(0x00070917), // top — rgba(7,9,23,0)
                0.5f to Color(0xBF245A8D), // middle — rgba(36,90,141,0.75)
                1.0f to Color(0xFF377CED), // bottom — rgba(55,124,237,1)
            ),
    )
