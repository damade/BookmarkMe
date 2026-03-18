package com.bookmark.bookmarkme.ui.components.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bookmark.bookmarkme.core.auth.AccountState
import com.bookmark.bookmarkme.core.preferences.BookmarkPreferences
import com.bookmark.bookmarkme.data.repository.onboarding.OnboardingRepository
import com.bookmark.bookmarkme.ui.navigation.splash.SplashNavigationState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlin.time.Duration.Companion.seconds

class SplashViewmodel(
    private val onboardingRepository: OnboardingRepository,
    private val preferences: BookmarkPreferences,
) : ViewModel() {
    val navigationState =
        flow {
            delay(2.seconds)
            val isFirstLaunch = onboardingRepository.isOnboardingCompleted()
            val isLoggedIn = preferences.accountDetails.get() is AccountState.LoggedIn
            if (!isLoggedIn) {
                emit(value = SplashNavigationState.Login)
            } else if (isFirstLaunch) {
                emit(value = SplashNavigationState.Onboarding)
            } else {
                emit(value = SplashNavigationState.Home)
            }
        }.stateIn(
            viewModelScope,
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
            initialValue = SplashNavigationState.None,
        )
}
