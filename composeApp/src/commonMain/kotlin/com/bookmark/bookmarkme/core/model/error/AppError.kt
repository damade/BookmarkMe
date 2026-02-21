package com.bookmark.bookmarkme.core.model.error

import com.bookmark.bookmarkme.core.model.network.HttpException

sealed class AppError {
    data class NetworkError(
        val httpException: HttpException,
    ) : AppError()

    data class BookmarkException(
        val message: String,
    ) : AppError()
}

fun AppError.toErrorMessage(): String =
    when (this) {
        is AppError.NetworkError -> "${this.httpException.httpStatusCode}: ${this.httpException.message}"

        is AppError.BookmarkException -> this.message
    }
