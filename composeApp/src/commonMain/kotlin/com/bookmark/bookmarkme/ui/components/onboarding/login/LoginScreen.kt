package com.bookmark.bookmarkme.ui.components.onboarding.login

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bookmark.bookmarkme.ui.core.adaptive.ScreenAdaptiveContent

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    ScreenAdaptiveContent(
        mobileContent = { LoginScreenMobile(modifier = modifier) },
        tabletContent = { LoginScreenTablet(modifier = modifier) },
        desktopContent = { LoginScreenTablet(modifier = modifier) },
    )
}
