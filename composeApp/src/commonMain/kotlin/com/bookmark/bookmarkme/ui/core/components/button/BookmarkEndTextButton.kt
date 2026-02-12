package com.bookmark.bookmarkme.ui.core.components.button

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.LocalTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import com.bookmark.bookmarkme.ui.core.components.spacing.BookmarkFillSpacer
import com.bookmark.bookmarkme.ui.core.components.text.BookmarkText

@Composable
internal fun BookmarkEndTextButton(
    onClick: () -> Unit,
    textContent: String,
    modifier: Modifier = Modifier,
    style: TextStyle = LocalTextStyle.current,
) {
    Row(modifier = modifier) {
        BookmarkFillSpacer()
        BookmarkText(
            text = textContent,
            style = style,
            modifier = Modifier.clickable(onClick = onClick),
        )
    }
}
