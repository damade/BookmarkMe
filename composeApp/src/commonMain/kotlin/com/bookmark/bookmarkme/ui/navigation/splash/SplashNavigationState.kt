package com.bookmark.bookmarkme.ui.navigation.splash

sealed interface SplashNavigationState {
    data object Onboarding : SplashNavigationState

    data object Home : SplashNavigationState

    data object None : SplashNavigationState

    data object Login : SplashNavigationState
}
