package com.bookmark.bookmarkme.ui.components.onboarding.login.shared

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import bookmarkme.composeapp.generated.resources.Res
import bookmarkme.composeapp.generated.resources.app_name
import bookmarkme.composeapp.generated.resources.login_description_one
import com.bookmark.bookmarkme.ui.core.components.text.BookmarkText
import com.bookmark.bookmarkme.ui.core.components.text.TextWithIcon
import com.bookmark.bookmarkme.ui.core.foundation.BookmarkPreviewTheme
import com.bookmark.bookmarkme.ui.core.foundation.util.PreviewLightDarkMobile
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
internal fun WelcomeSection(modifier: Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        BookmarkText(
            text = stringResource(resource = Res.string.login_description_one),
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.padding(vertical = 6.dp),
        )

        TextWithIcon(
            text = stringResource(resource = Res.string.app_name),
            onClickIcon = { /* Handle icon click if needed */ },
        )
    }
}

@Composable
@PreviewLightDarkMobile
private fun WelcomeSectionPreview() {
    BookmarkPreviewTheme {
        WelcomeSection(
            modifier = Modifier.padding(all = 16.dp),
        )
    }
}
