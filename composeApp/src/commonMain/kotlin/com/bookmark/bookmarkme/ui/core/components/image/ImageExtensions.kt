package com.bookmark.bookmarkme.ui.core.components.image

import bookmarkme.composeapp.generated.resources.Res

internal fun String.toResUri() = Res.getUri(this)
