package com.bookmark.bookmarkme.core.utils

import com.bookmark.bookmarkme.core.model.error.AppError
import com.bookmark.bookmarkme.core.model.network.HttpException

fun Exception.toBookmarkException(): AppError =
    AppError.BookmarkException(
        message = this.message ?: cause?.stackTraceToString() ?: "Something went wrong",
    )

fun Throwable.toBookmarkException(): AppError = AppError.BookmarkException(message = this.message ?: stackTraceToString())

fun Throwable.toAppError(): AppError =
    when {
        this is HttpException -> AppError.NetworkError(httpException = this)

        else -> this.toBookmarkException()
    }
