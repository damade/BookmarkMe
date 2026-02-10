package com.bookmark.bookmarkme.ui.core.components.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.bookmark.bookmarkme.extensions.forEach
import com.bookmark.bookmarkme.ui.core.components.button.BookmarkButtonStyle.Borderless
import com.bookmark.bookmarkme.ui.core.components.button.BookmarkButtonStyle.Critical
import com.bookmark.bookmarkme.ui.core.components.button.BookmarkButtonStyle.Default
import com.bookmark.bookmarkme.ui.core.components.button.BookmarkButtonStyle.Inverted
import com.bookmark.bookmarkme.ui.core.components.button.BookmarkButtonStyle.Outlined
import com.bookmark.bookmarkme.ui.core.components.button.BookmarkButtonStyle.OutlinedBlack
import com.bookmark.bookmarkme.ui.core.components.button.BookmarkButtonStyle.OutlinedNeutral
import com.bookmark.bookmarkme.ui.core.components.spacing.BookmarkVerticalSpacer
import com.bookmark.bookmarkme.ui.core.components.surface.BookmarkSurface
import com.bookmark.bookmarkme.ui.core.components.text.BookmarkText
import com.bookmark.bookmarkme.ui.core.foundation.BookmarkPreviewTheme
import com.bookmark.bookmarkme.ui.core.foundation.BookmarkTheme

enum class BookmarkButtonStyle {
    Default,
    Inverted,
    Outlined,
    OutlinedNeutral,
    OutlinedBlack,
    Borderless,
    Critical,
}

@Composable
fun BookmarkButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    style: BookmarkButtonStyle = Default,
    shape: Shape = RoundedCornerShape(size = 8.dp),
    minimumInteractiveSize: Dp = Dp.Unspecified,
    contentPadding: PaddingValues =
        PaddingValues(
            horizontal = 24.dp,
            vertical = 12.dp,
        ),
    contentArrangement: Arrangement.Horizontal = Arrangement.Center,
    content: @Composable (contentColor: Color) -> Unit,
) {
    val backgroundColor =
        getBackgroundColor(
            style = style,
            enabled = enabled,
        )
    val contentColor =
        getContentColor(
            style = style,
            enabled = enabled,
        )
    val border =
        getBorder(
            style = style,
            enabled = enabled,
        )

    BookmarkSurface(
        containerColor = backgroundColor,
        onClick = onClick,
        enabled = enabled,
        border = border,
        shape = shape,
        minimumInteractiveSize = minimumInteractiveSize,
        modifier =
            modifier.semantics {
                role = Role.Button
            },
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = contentArrangement,
            modifier = Modifier.padding(contentPadding),
        ) {
            content(contentColor)
        }
    }
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun BookmarkButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    isLoading: Boolean = false,
    style: BookmarkButtonStyle = Default,
    textStyle: TextStyle = MaterialTheme.typography.bodyMediumEmphasized,
    shape: Shape = RoundedCornerShape(size = 8.dp),
    minimumInteractiveSize: Dp = Dp.Unspecified,
    contentPadding: PaddingValues = PaddingValues(all = 12.dp),
    textArrangement: Arrangement.Horizontal = Arrangement.Center,
) {
    BookmarkButton(
        onClick = onClick,
        enabled = enabled,
        style = style,
        shape = shape,
        minimumInteractiveSize = minimumInteractiveSize,
        contentPadding = contentPadding,
        contentArrangement = textArrangement,
        modifier = modifier,
    ) { contentColor ->
        if (!isLoading) {
            BookmarkText(
                color = contentColor,
                text = text,
                style = textStyle,
                maxLines = 1,
            )
        } else {
            CircularProgressIndicator(
                color = contentColor,
                strokeWidth = 2.dp,
                modifier = Modifier.size(16.dp),
            )
        }
    }
}

@Composable
private fun getBackgroundColor(
    style: BookmarkButtonStyle,
    enabled: Boolean,
): Color =
    when (style) {
        Default ->
            if (enabled) {
                MaterialTheme.colorScheme.primary
            } else {
                MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f)
            }

        Inverted ->
            if (enabled) {
                MaterialTheme.colorScheme.primaryContainer
            } else {
                MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f)
            }

        Outlined, OutlinedNeutral,
        OutlinedBlack, Borderless,
        -> BookmarkTheme.colors.transparent

        Critical ->
            if (enabled) {
                MaterialTheme.colorScheme.error
            } else {
                MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f)
            }
    }

@Composable
private fun getContentColor(
    style: BookmarkButtonStyle,
    enabled: Boolean,
): Color =
    when (style) {
        Default ->
            if (enabled) {
                MaterialTheme.colorScheme.onPrimary
            } else {
                MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
            }

        Inverted ->
            if (enabled) {
                MaterialTheme.colorScheme.onPrimaryContainer
            } else {
                MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
            }

        Outlined ->
            if (enabled) {
                MaterialTheme.colorScheme.primary
            } else {
                MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
            }

        OutlinedNeutral, OutlinedBlack ->
            if (enabled) {
                MaterialTheme.colorScheme.onSurface
            } else {
                MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
            }

        Borderless ->
            if (enabled) {
                MaterialTheme.colorScheme.primary
            } else {
                MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
            }

        Critical ->
            if (enabled) {
                MaterialTheme.colorScheme.onError
            } else {
                MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
            }
    }

@Composable
private fun getBorder(
    style: BookmarkButtonStyle,
    enabled: Boolean,
): BorderStroke? =
    when (style) {
        Default, Critical, Borderless -> null
        Inverted ->
            if (enabled) {
                BorderStroke(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.primary,
                )
            } else {
                null
            }

        Outlined ->
            BorderStroke(
                width = 1.dp,
                color =
                    if (enabled) {
                        MaterialTheme.colorScheme.outline
                    } else {
                        MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f)
                    },
            )

        OutlinedNeutral ->
            BorderStroke(
                width = 1.dp,
                color =
                    if (enabled) {
                        MaterialTheme.colorScheme.outlineVariant
                    } else {
                        MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f)
                    },
            )

        OutlinedBlack ->
            BorderStroke(
                width = 1.dp,
                color =
                    if (enabled) {
                        MaterialTheme.colorScheme.onSurface
                    } else {
                        MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f)
                    },
            )
    }

@Preview(showBackground = true)
@Composable
private fun BookmarkButtonPreview() {
    BookmarkPreviewTheme {
        Column {
            BookmarkButtonStyle.entries.forEach {
                BookmarkText(it.name, modifier = Modifier.background(Color.Green))
                BookmarkVerticalSpacer(height = 4.dp)
                Boolean.forEach { enabled ->
                    BookmarkButton(
                        text = "This is a ${if (enabled) "enabled" else "disabled"} Button",
                        onClick = {},
                        style = it,
                        enabled = enabled,
                    )
                }
                HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp), thickness = 2.dp)
            }
        }
    }
}
