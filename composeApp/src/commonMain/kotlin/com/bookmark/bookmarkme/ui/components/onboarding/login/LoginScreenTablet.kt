package com.bookmark.bookmarkme.ui.components.onboarding.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import com.bookmark.bookmarkme.ui.components.onboarding.login.shared.LoginForm
import com.bookmark.bookmarkme.ui.core.components.surface.BookmarkSurface
import com.bookmark.bookmarkme.ui.core.foundation.BookmarkPreviewTheme
import com.bookmark.bookmarkme.ui.core.foundation.util.PreviewLightDarkTablet
import org.jetbrains.compose.resources.painterResource

@Composable
internal fun LoginScreenTablet(modifier: Modifier = Modifier) {
    val gradientBrush =
        Brush.verticalGradient(
            colorStops =
                arrayOf(
                    0.0f to Color(0x00070917), // top — rgba(7,9,23,0)
                    0.5f to Color(0xBF245A8D), // middle — rgba(36,90,141,0.75)
                    1.0f to Color(0xFF377CED), // bottom — rgba(55,124,237,1)
                ),
        )

    BookmarkSurface(containerColor = MaterialTheme.colorScheme.onSurface) {
        Row(modifier = modifier.padding(all = 16.dp)) {
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
            }

            Column(modifier = Modifier.weight(weight = 1f)) {
                LoginForm(
                    modifier = Modifier.weight(weight = 1f),
                    signInWithGoogle = { /* Handle Google Sign-In */ },
                    signInWithApple = { /* Handle Apple Sign-In */ },
                )
            }
        }
    }
//    Box(
//        modifier = modifier
//            .fillMaxSize()
//            .background(brush = gradientBrush),
//    )
}

@Composable
@PreviewLightDarkTablet
private fun LoginScreenTabletPreview() {
    BookmarkPreviewTheme {
        LoginScreenTablet()
    }
}
