package com.bookmark.bookmarkme.ui.components.login

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bookmark.bookmarkme.ui.core.adaptive.ScreenAdaptiveContent
import com.bookmark.bookmarkme.ui.core.foundation.BookmarkPreviewTheme
import com.bookmark.bookmarkme.ui.core.foundation.util.PreviewLightDark

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    ScreenAdaptiveContent(
        mobileContent = { LoginScreenMobile(modifier = modifier) },
        desktopAndTabletContent = { LoginScreenTablet(modifier = modifier) },
    )
}

@Composable
@PreviewLightDark
private fun LoginScreenPreview() {
    BookmarkPreviewTheme {
        LoginScreen()
    }
}
