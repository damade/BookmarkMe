package com.bookmark.bookmarkme.core.preferences

import com.bookmark.bookmarkme.core.auth.AccountState

interface BookmarkPreferences {
    val isFirstLaunch: Preference<Boolean>
    val accountDetails: Preference<AccountState>

    val theme: Preference<Theme>
    val useDynamicColors: Preference<Boolean>

    enum class Theme(
        val value: String,
    ) {
        LIGHT(value = "light"),
        DARK(value = "dark"),
        SYSTEM(value = "system"),
    }
}
