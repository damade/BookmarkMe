package com.bookmark.bookmarkme.ui.components.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import bookmarkme.composeapp.generated.resources.Res
import bookmarkme.composeapp.generated.resources.login_illustration
import com.bookmark.bookmarkme.ui.components.login.shared.LoginForm
import com.bookmark.bookmarkme.ui.components.login.shared.LoginScreenGradient
import com.bookmark.bookmarkme.ui.components.login.shared.WelcomeSection
import com.bookmark.bookmarkme.ui.components.login.shared.gradient1Brush
import com.bookmark.bookmarkme.ui.components.login.shared.gradient2Brush
import com.bookmark.bookmarkme.ui.core.components.surface.BookmarkSurface
import com.bookmark.bookmarkme.ui.core.foundation.BookmarkPreviewTheme
import com.bookmark.bookmarkme.ui.core.foundation.util.PreviewLightDarkMobile
import org.jetbrains.compose.resources.painterResource

@Composable
fun LoginScreenMobile(modifier: Modifier = Modifier) {
    BookmarkSurface(modifier = modifier, containerColor = MaterialTheme.colorScheme.onSurface) {
        LoginScreenGradient(
            firstGradient = gradient1Brush,
            secondGradient = gradient2Brush,
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize(),
        ) {
            WelcomeSection(modifier = Modifier.padding(vertical = 32.dp))
            Box(
                modifier = Modifier.weight(weight = 1f),
                contentAlignment = Alignment.Center,
            ) {
                Image(
                    painter = painterResource(resource = Res.drawable.login_illustration),
                    contentDescription = "Bookmark categories illustration",
                    modifier =
                        Modifier
                            .fillMaxSize(),
                    contentScale = ContentScale.Crop,
                )
                val newBrush =
                    Brush.verticalGradient(
                        colorStops =
                            arrayOf(
                                0.0f to Color(0xBF245A8D),
                                1.0f to Color(0x00070917),
                            ),
                    )
                Box(
                    modifier =
                        Modifier
                            .fillMaxSize()
                            .background(brush = gradient1Brush),
                )
            }
            Column(
                modifier = Modifier.weight(weight = 1f).padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                LoginForm(
                    modifier = Modifier,
                    signInWithGoogle = { /* Handle Google Sign-In */ },
                    signInWithApple = { /* Handle Apple Sign-In */ },
                )
            }
        }
    }
}

@Composable
@PreviewLightDarkMobile
private fun LoginScreenMobilePreview() {
    BookmarkPreviewTheme {
        LoginScreenMobile()
    }
}
