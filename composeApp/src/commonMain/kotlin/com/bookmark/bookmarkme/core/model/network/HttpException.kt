package com.bookmark.bookmarkme.core.model.network

import io.ktor.http.HttpStatusCode

data class HttpException(
    val httpStatusCode: HttpStatusCode,
    val error: ErrorBody,
    override val message: String?,
) : Throwable(message = message)
