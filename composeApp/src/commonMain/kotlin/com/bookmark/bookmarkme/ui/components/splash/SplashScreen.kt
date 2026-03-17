package com.bookmark.bookmarkme.ui.components.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.bookmark.bookmarkme.ui.components.login.LoginScreenMobile
import com.bookmark.bookmarkme.ui.components.login.LoginScreenTablet
import com.bookmark.bookmarkme.ui.core.adaptive.ScreenAdaptiveContent
import com.bookmark.bookmarkme.ui.core.foundation.BookmarkPreviewTheme
import com.bookmark.bookmarkme.ui.core.foundation.util.PreviewLightDark
import com.bookmark.bookmarkme.ui.navigation.splash.SplashNavigationState
import kotlinx.coroutines.flow.collectLatest

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    splashViewModel: SplashViewmodel,
    navigateToOnboarding: () -> Unit,
    navigateToLogin: () -> Unit,
    navigateToHome: () -> Unit,
) {
    LaunchedEffect(splashViewModel.navigationState) {
        splashViewModel.navigationState.collectLatest {
            when (it) {
                SplashNavigationState.Onboarding -> navigateToOnboarding()
                SplashNavigationState.Login -> navigateToLogin()
                SplashNavigationState.Home -> navigateToHome()
                SplashNavigationState.None -> {}
            }
        }
    }
    SplashScreenContent(modifier = modifier)
}

@Composable
private fun SplashScreenContent(
    modifier: Modifier = Modifier,
) {
    ScreenAdaptiveContent(
        mobileContent = { LoginScreenMobile(modifier = modifier) },
        desktopAndTabletContent = { LoginScreenTablet(modifier = modifier) },
    )
}

@Composable
@PreviewLightDark
private fun SplashScreenPreview() {
    BookmarkPreviewTheme {
        SplashScreenContent()
    }
}
