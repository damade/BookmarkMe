package com.bookmark.bookmarkme.core.model.network

import kotlinx.serialization.Serializable

@Serializable
data class ErrorBody(
    val errors: List<String>,
)
