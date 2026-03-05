package com.bookmark.bookmarkme.ui.components.onboarding.login.shared

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import bookmarkme.composeapp.generated.resources.Res
import bookmarkme.composeapp.generated.resources.login_description_one
import bookmarkme.composeapp.generated.resources.login_description_three
import bookmarkme.composeapp.generated.resources.login_description_two
import bookmarkme.composeapp.generated.resources.signin_info
import bookmarkme.composeapp.generated.resources.signin_privacy_agreement_part_one
import bookmarkme.composeapp.generated.resources.signin_privacy_agreement_part_two
import bookmarkme.composeapp.generated.resources.signin_with_apple
import bookmarkme.composeapp.generated.resources.signin_with_google
import com.bookmark.bookmarkme.ui.core.components.button.BookmarkButton
import com.bookmark.bookmarkme.ui.core.components.spacing.BookmarkVerticalSpacer
import com.bookmark.bookmarkme.ui.core.components.text.BookmarkText
import com.bookmark.bookmarkme.ui.core.components.text.buildStyledAnnotatedString
import com.bookmark.bookmarkme.ui.core.foundation.BookmarkPreviewTheme
import com.bookmark.bookmarkme.ui.core.foundation.util.PreviewLightDarkMobile
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
internal fun LoginForm(
    modifier: Modifier,
    signInWithGoogle: () -> Unit,
    signInWithApple: () -> Unit,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        BookmarkText(
            text = stringResource(resource = Res.string.login_description_one),
            style = MaterialTheme.typography.titleLargeEmphasized,
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.padding(vertical = 12.dp),
        )

        BookmarkText(
            text =
                stringResource(
                    resource = Res.string.login_description_two,
                ).buildStyledAnnotatedString(),
            color = MaterialTheme.colorScheme.onPrimary,
        )

        BookmarkText(
            text =
                stringResource(
                    resource = Res.string.login_description_three,
                ).buildStyledAnnotatedString(),
            color = MaterialTheme.colorScheme.onPrimary,
        )

        BookmarkVerticalSpacer(height = 16.dp)

        BookmarkButton(
            text = stringResource(resource = Res.string.signin_with_google),
            onClick = signInWithGoogle,
            shape = CircleShape,
        )

        BookmarkVerticalSpacer(height = 16.dp)

        BookmarkButton(
            text = stringResource(resource = Res.string.signin_with_apple),
            onClick = signInWithApple,
            shape = CircleShape,
        )

        BookmarkText(
            text = stringResource(resource = Res.string.signin_info),
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.padding(vertical = 16.dp),
        )

        BookmarkText(
            text =
                stringResource(
                    resource = Res.string.signin_privacy_agreement_part_one,
                ).buildStyledAnnotatedString(),
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onPrimary,
        )
        BookmarkText(
            text =
                stringResource(
                    resource = Res.string.signin_privacy_agreement_part_two,
                ).buildStyledAnnotatedString(),
            style = MaterialTheme.typography.titleMediumEmphasized,
            color = MaterialTheme.colorScheme.onPrimary,
        )
    }
}

@Composable
@PreviewLightDarkMobile
private fun LoginFormPreview() {
    BookmarkPreviewTheme {
        LoginForm(
            modifier = Modifier.padding(all = 16.dp),
            signInWithGoogle = {},
            signInWithApple = {},
        )
    }
}
