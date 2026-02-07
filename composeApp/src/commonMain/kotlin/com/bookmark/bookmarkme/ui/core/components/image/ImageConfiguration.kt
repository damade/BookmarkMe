package com.bookmark.bookmarkme.ui.core.components.image

import org.jetbrains.compose.resources.DrawableResource

data class ImageConfiguration(
    val placeholder: DrawableResource? = null,
    val error: DrawableResource? = null,
    val onImageLoadError: () -> Unit = { },
    val onImageLoadSuccess: () -> Unit = { },
    val onImageLoading: () -> Unit = { },
)

sealed interface ImageType {
    data class Url(
        val link: String,
    ) : ImageType

    data class Resource(
        val uri: String,
    ) : ImageType
}
