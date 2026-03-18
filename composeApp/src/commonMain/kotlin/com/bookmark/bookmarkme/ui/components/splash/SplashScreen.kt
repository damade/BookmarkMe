package com.bookmark.bookmarkme.ui.components.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import bookmarkme.composeapp.generated.resources.Res
import bookmarkme.composeapp.generated.resources.app_icon
import com.bookmark.bookmarkme.ui.core.components.surface.BookmarkSurface
import com.bookmark.bookmarkme.ui.core.foundation.BookmarkPreviewTheme
import com.bookmark.bookmarkme.ui.core.foundation.util.PreviewLightDark
import com.bookmark.bookmarkme.ui.navigation.splash.SplashNavigationState
import kotlinx.coroutines.flow.collectLatest
import org.jetbrains.compose.resources.painterResource

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    splashViewModel: SplashViewmodel,
    navigateToNotificationPreferences: () -> Unit,
    navigateToLogin: () -> Unit,
    navigateToHome: () -> Unit,
) {
    LaunchedEffect(splashViewModel.navigationState) {
        splashViewModel.navigationState.collectLatest {
            when (it) {
                SplashNavigationState.Onboarding -> navigateToNotificationPreferences()
                SplashNavigationState.Login -> navigateToLogin()
                SplashNavigationState.Home -> navigateToHome()
                SplashNavigationState.None -> {}
            }
        }
    }
    SplashScreenContent(modifier = modifier)
}

@Composable
private fun SplashScreenContent(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        BookmarkSurface {
            Icon(
                painter = painterResource(resource = Res.drawable.app_icon),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurface,
            )
        }
    }
}

@Composable
@PreviewLightDark
private fun SplashScreenPreview() {
    BookmarkPreviewTheme {
        SplashScreenContent()
    }
}
