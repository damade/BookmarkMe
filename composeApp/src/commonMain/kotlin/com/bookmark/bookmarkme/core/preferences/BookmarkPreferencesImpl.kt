package com.bookmark.bookmarkme.core.preferences

import com.bookmark.bookmarkme.core.auth.AccountDetails
import com.bookmark.bookmarkme.core.auth.AccountState
import com.bookmark.bookmarkme.core.preferences.BookmarkPreferences.Theme
import com.bookmark.bookmarkme.di.coroutine.AppCoroutineDispatchers
import com.bookmark.bookmarkme.di.coroutine.AppCoroutineScope
import com.russhwolf.settings.ExperimentalSettingsApi
import com.russhwolf.settings.ObservableSettings
import com.russhwolf.settings.coroutines.toFlowSettings
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.WhileSubscribed
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.withContext
import kotlin.getValue
import kotlin.time.Duration.Companion.seconds

@OptIn(ExperimentalSettingsApi::class)
class BookmarkPreferencesImpl(
    settings: Lazy<ObservableSettings>,
    private val coroutineScope: AppCoroutineScope,
    private val dispatchers: AppCoroutineDispatchers,
) : BookmarkPreferences {
    private val settings: ObservableSettings by settings
    private val flowSettings by lazy { settings.value.toFlowSettings(dispatchers.io) }

    override val theme: Preference<Theme> by lazy {
        MappingPreference(
            KEY_THEME,
            defaultValue = Theme.SYSTEM,
            toValue = { storedValue ->
                Theme.entries.find { it.value == storedValue } ?: Theme.SYSTEM
            },
            fromValue = { it.value },
        )
    }

    override val useDynamicColors: Preference<Boolean> by lazy {
        BooleanPreference(KEY_USE_DYNAMIC_COLORS, true)
    }

    override val accountDetails: Preference<AccountState> by lazy {
        MappingPreference(
            key = KEY_ACCOUNT_DETAILS,
            defaultValue = AccountState.LoggedOut,
            toValue = ::getAccountStateFromStoredValue,
            fromValue = ::fromAccountStateToStoredValue,
        )
    }

    override val isFirstLaunch: Preference<Boolean> by lazy {
        BooleanPreference(KEY_IS_FIRST_LAUNCH, defaultValue = true)
    }

    private inner class BooleanPreference(
        private val key: String,
        override val defaultValue: Boolean = false,
    ) : Preference<Boolean> {
        override suspend fun set(value: Boolean) =
            withContext(dispatchers.io) {
                settings.putBoolean(key = key, value = value)
            }

        override suspend fun get(): Boolean =
            withContext(dispatchers.io) {
                settings.getBoolean(key = key, defaultValue = defaultValue)
            }

        override val flow: StateFlow<Boolean> by lazy {
            flowSettings
                .getBooleanFlow(key, defaultValue)
                .stateIn(
                    scope = coroutineScope,
                    started = SharingStarted.WhileSubscribed(SUBSCRIBED_TIMEOUT),
                    initialValue = defaultValue,
                )
        }
    }

    private inner class MappingPreference<V>(
        private val key: String,
        override val defaultValue: V,
        private val toValue: (String) -> V,
        private val fromValue: (V) -> String,
    ) : Preference<V> {
        override suspend fun set(value: V) =
            withContext(dispatchers.io) {
                settings.putString(key = key, value = fromValue(value))
            }

        override suspend fun get(): V =
            withContext(dispatchers.io) {
                settings.getStringOrNull(key)?.let(toValue) ?: defaultValue
            }

        override val flow: Flow<V> by lazy {
            flowSettings
                .getStringOrNullFlow(key)
                .map { it?.let(toValue) ?: defaultValue }
                .shareIn(
                    scope = coroutineScope,
                    started = SharingStarted.WhileSubscribed(SUBSCRIBED_TIMEOUT),
                )
        }
    }

    private companion object {
        val SUBSCRIBED_TIMEOUT = 20.seconds
    }

    /**
     * Converts a stored string value into an AccountState. The expected format for a logged-in state is:
     * "logged_in:{id}:{name}:{email}". If the format is incorrect or if the value indicates a logged-out state, it returns AccountState
     * TODO: Consider using a more robust serialization method (e.g., JSON) for storing complex data like account details, to avoid issues with string parsing and to support future extensions more easily.
     */
    private fun getAccountStateFromStoredValue(storedValue: String): AccountState =
        when {
            storedValue.startsWith("logged_in:") -> {
                val parts = storedValue.removePrefix("logged_in:").split(":")
                if (parts.size == 3) {
                    val (id, name, email) = parts
                    AccountState.LoggedIn(
                        details = AccountDetails(id = id, name = name, email = email),
                    )
                } else {
                    AccountState.LoggedOut
                }
            }

            storedValue == "logged_out" -> AccountState.LoggedOut
            else -> AccountState.LoggedOut
        }

    private fun fromAccountStateToStoredValue(details: AccountState): String =
        when (details) {
            is AccountState.LoggedIn -> "logged_in:${details.details.id}:${details.details.name}:${details.details.email}"
            is AccountState.LoggedOut -> "logged_out"
        }
}

internal const val KEY_THEME = "pref_theme"
internal const val KEY_USE_DYNAMIC_COLORS = "pref_dynamic_colors"
internal const val KEY_IS_FIRST_LAUNCH = "pref_is_first_launch"
internal const val KEY_ACCOUNT_DETAILS = "pref_account_details"

private fun ObservableSettings.toggleBoolean(
    key: String,
    defaultValue: Boolean = false,
) {
    putBoolean(key, !getBoolean(key, defaultValue))
}
