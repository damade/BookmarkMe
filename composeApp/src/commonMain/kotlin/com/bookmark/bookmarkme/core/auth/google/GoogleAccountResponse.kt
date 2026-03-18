package com.bookmark.bookmarkme.core.auth.google

data class GoogleAccountResponse(
    val token: String,
    val displayName: String,
    val profileImageUrl: String?,
)
