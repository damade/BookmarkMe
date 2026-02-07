package com.bookmark.bookmarkme.ui.core.components.image

import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix

object ImageColorFilters {
    val grayScaleColorFilter =
        ColorFilter.colorMatrix(
            colorMatrix = ColorMatrix().apply { setToSaturation(0f) },
        )
}
