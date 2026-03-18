package com.bookmark.bookmarkme.core.auth

data class AccountDetails(
    val id: String,
    val name: String,
    val email: String,
)

sealed interface AccountState {
    data class LoggedIn(
        val details: AccountDetails,
    ) : AccountState

    data object LoggedOut : AccountState
}
