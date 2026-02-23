package com.bookmark.bookmarkme.ui.components.onboarding.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import bookmarkme.composeapp.generated.resources.Res
import bookmarkme.composeapp.generated.resources.login_description_one
import bookmarkme.composeapp.generated.resources.login_description_two
import bookmarkme.composeapp.generated.resources.signin_info
import bookmarkme.composeapp.generated.resources.signin_privacy_agreement
import bookmarkme.composeapp.generated.resources.signin_with_apple
import bookmarkme.composeapp.generated.resources.signin_with_google
import com.bookmark.bookmarkme.ui.core.components.button.BookmarkButton
import com.bookmark.bookmarkme.ui.core.components.spacing.BookmarkVerticalSpacer
import com.bookmark.bookmarkme.ui.core.components.text.BookmarkText
import com.bookmark.bookmarkme.ui.core.components.text.buildStyledAnnotatedString
import org.jetbrains.compose.resources.stringResource

@Composable
@Preview
fun LoginScreenTablet(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
    ) {
        Box(modifier = Modifier.weight(weight = 1f)) {
            // Placeholder for an image or illustration related to log in
        }
        LoginForm(modifier = Modifier.weight(weight = 1f))
    }
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
private fun LoginForm(modifier: Modifier) {
    Column(modifier = modifier) {
        BookmarkText(
            text = stringResource(resource = Res.string.login_description_one),
            style = MaterialTheme.typography.titleLargeEmphasized,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(vertical = 12.dp),
        )

        BookmarkText(
            text =
                stringResource(
                    resource = Res.string.login_description_two,
                ).buildStyledAnnotatedString(),
            color = MaterialTheme.colorScheme.primary,
        )

        BookmarkVerticalSpacer(height = 24.dp)

        BookmarkButton(
            text = stringResource(resource = Res.string.signin_with_google),
            onClick = { /* Handle login click */ },
        )

        BookmarkVerticalSpacer(height = 24.dp)

        BookmarkButton(
            text = stringResource(resource = Res.string.signin_with_google),
            onClick = { /* Handle login click */ },
            shape = CircleShape,
        )

        BookmarkButton(
            text = stringResource(resource = Res.string.signin_with_apple),
            onClick = { /* Handle login click */ },
            shape = CircleShape,
        )

        BookmarkText(
            text = stringResource(resource = Res.string.signin_info),
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(vertical = 12.dp),
        )

        BookmarkText(
            text =
                stringResource(
                    resource = Res.string.signin_privacy_agreement,
                ).buildStyledAnnotatedString(),
            style = MaterialTheme.typography.titleLargeEmphasized,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(vertical = 12.dp),
        )
    }
}
