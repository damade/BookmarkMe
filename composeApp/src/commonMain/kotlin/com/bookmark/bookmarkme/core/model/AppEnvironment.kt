package com.bookmark.bookmarkme.core.model

sealed class AppEnvironment(
    val baseUrl: String,
) {
    data object Production : AppEnvironment(
        baseUrl = "https://api-bookmark.ogbontarigi.com/api/v1",
    )

    data object Staging : AppEnvironment(
        baseUrl = "https://stage-api-bookmark.ogbontarigi.com/api/v1",
    )
}
