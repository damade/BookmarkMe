package com.bookmark.bookmarkme.ui.core.components.image

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImage
import org.jetbrains.compose.resources.painterResource

@Composable
fun BookmarkImage(
    imageType: ImageType,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Crop,
    colorFilter: ColorFilter? = null,
    alignment: Alignment = Alignment.Center,
    imageOptions: ImageConfiguration = ImageConfiguration(),
) {
    AsyncImage(
        modifier = modifier,
        model = imageType.getImageModel(),
        contentDescription = contentDescription,
        contentScale = contentScale,
        colorFilter = colorFilter,
        alignment = alignment,
        placeholder = imageOptions.placeholder?.let { painterResource(resource = it) },
        onLoading = { imageOptions.onImageLoading() },
        error = imageOptions.error?.let { painterResource(resource = it) },
        onError = { imageOptions.onImageLoadError() },
        onSuccess = {
            imageOptions.onImageLoadSuccess()
        },
    )
}

private fun ImageType.getImageModel() =
    when (this) {
        is ImageType.Url -> link
        is ImageType.Resource -> uri
    }
