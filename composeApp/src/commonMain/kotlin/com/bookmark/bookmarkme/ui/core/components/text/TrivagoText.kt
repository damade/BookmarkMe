package com.bookmark.bookmarkme.ui.core.components.text

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.bookmark.bookmarkme.ui.core.foundation.BookmarkPreviewTheme
import com.bookmark.bookmarkme.ui.model.StringHolder
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.pluralStringResource
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun BookmarkText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onSurface,
    style: TextStyle = MaterialTheme.typography.bodyMediumEmphasized,
    textAlign: TextAlign? = null,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    textDecoration: TextDecoration? = null,
    maxLines: Int = Int.MAX_VALUE,
    minLines: Int = 1,
    onTextLayout: ((TextLayoutResult) -> Unit)? = null,
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        overflow = overflow,
        maxLines = maxLines,
        minLines = minLines,
        onTextLayout = onTextLayout,
        style = style,
        textAlign = textAlign,
        textDecoration = textDecoration,
    )
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun BookmarkText(
    text: AnnotatedString,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onSurface,
    style: TextStyle = MaterialTheme.typography.bodyMediumEmphasized,
    textAlign: TextAlign? = null,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    textDecoration: TextDecoration? = null,
    maxLines: Int = Int.MAX_VALUE,
    minLines: Int = 1,
    onTextLayout: ((TextLayoutResult) -> Unit)? = null,
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        overflow = overflow,
        maxLines = maxLines,
        minLines = minLines,
        onTextLayout = onTextLayout ?: {},
        style = style,
        textAlign = textAlign,
        textDecoration = textDecoration,
    )
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun BookmarkText(
    text: StringHolder,
    modifier: Modifier = Modifier,
    textColor: Color = MaterialTheme.colorScheme.onSurface,
    style: TextStyle = MaterialTheme.typography.bodyMediumEmphasized,
    textAlign: TextAlign? = null,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    textDecoration: TextDecoration? = null,
    maxLines: Int = Int.MAX_VALUE,
    minLines: Int = 1,
    onTextLayout: ((TextLayoutResult) -> Unit)? = null,
) {
    Text(
        text = text.value,
        modifier = modifier,
        color = textColor,
        overflow = overflow,
        maxLines = maxLines,
        minLines = minLines,
        onTextLayout = onTextLayout,
        style = style,
        textAlign = textAlign,
        textDecoration = textDecoration,
    )
}

private val StringHolder.value
    @Composable
    get() = when (this) {
        is StringHolder.Value -> value
        is StringHolder.Resource -> stringResource(resId)
        is StringHolder.ParametrizedResource -> stringResource(resId, *formatArgs.toTypedArray())
        is StringHolder.ParametrizedMixedResource -> stringResource(
            resId,
            *formatArgs.map {
                when (it) {
                    is String -> it
                    is Double -> it.toString()
                    is StringResource -> stringResource(it)
                    else -> throw IllegalArgumentException("Unsupported format argument type")
                }
            }.toTypedArray(),
        )
        is StringHolder.Plural -> pluralStringResource(resId, count, *formatArgs.toTypedArray())
    }

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Preview(showBackground = true)
@Composable
private fun BookmarkTextPreview() {
    BookmarkPreviewTheme {
        Column {
            listOf(
                MaterialTheme.typography.bodyLarge,
                MaterialTheme.typography.bodyMedium,
                MaterialTheme.typography.bodySmall,
                MaterialTheme.typography.bodyLargeEmphasized,
                MaterialTheme.typography.bodyMediumEmphasized,
                MaterialTheme.typography.bodySmallEmphasized,
                MaterialTheme.typography.titleLarge,
                MaterialTheme.typography.titleMedium,
                MaterialTheme.typography.titleSmall,
                MaterialTheme.typography.titleLargeEmphasized,
                MaterialTheme.typography.titleMediumEmphasized,
                MaterialTheme.typography.titleSmallEmphasized,
                MaterialTheme.typography.headlineLarge,
                MaterialTheme.typography.headlineMedium,
                MaterialTheme.typography.headlineSmall,
                MaterialTheme.typography.headlineLargeEmphasized,
                MaterialTheme.typography.headlineMediumEmphasized,
                MaterialTheme.typography.headlineSmallEmphasized,
                MaterialTheme.typography.displayLarge,
                MaterialTheme.typography.displayMedium,
                MaterialTheme.typography.displaySmall,
                MaterialTheme.typography.displayLargeEmphasized,
                MaterialTheme.typography.displayMediumEmphasized,
                MaterialTheme.typography.displaySmallEmphasized,
                MaterialTheme.typography.labelLarge,
                MaterialTheme.typography.labelMedium,
                MaterialTheme.typography.labelSmall,
                MaterialTheme.typography.labelLargeEmphasized,
                MaterialTheme.typography.labelMediumEmphasized,
                MaterialTheme.typography.labelSmallEmphasized,
            ).forEach { style ->
                BookmarkText(
                    text = "Preview",
                    style = style,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TrivagoAnnotatedTextPreview() {
    BookmarkPreviewTheme {
        Column {
            BookmarkText(text = "Some text without annotation".buildStyledAnnotatedString())
            BookmarkText(text = "Some text with *Bold* annotation".buildStyledAnnotatedString())
            BookmarkText(text = "Some text with #Link# annotation".buildStyledAnnotatedString())
            BookmarkText(text = "*Bold*: at the start".buildStyledAnnotatedString())
            BookmarkText(text = "#Link#: at the start".buildStyledAnnotatedString())
            BookmarkText(text = "at the end: *Bold*".buildStyledAnnotatedString())
            BookmarkText(text = "at the end: #Link#".buildStyledAnnotatedString())
            BookmarkText(text = "Some text with *Bold1* with *Bold2* and #Link# annotations".buildStyledAnnotatedString())
            BookmarkText(text = "Some text with *Bold1* with *Another Bold* and #Link1# with #Another Link# annotations".buildStyledAnnotatedString())
            BookmarkText(text = "Some text with *#BoldAndLink#* annotation".buildStyledAnnotatedString())
            BookmarkText(text = "Some text with #*BoldAndLink*# annotation".buildStyledAnnotatedString())
            BookmarkText(text = "Some text with #*BoldAndLink#* annotation".buildStyledAnnotatedString())
            BookmarkText(text = "Some text with *BoldAndLink#* annotation (only bold is valid)".buildStyledAnnotatedString())
            BookmarkText(text = "Some text with #BoldAndLink#* annotation (only link is valid)".buildStyledAnnotatedString())
            BookmarkText(text = "Some text with *invalid# annotation".buildStyledAnnotatedString())
            BookmarkText(text = "Some text with empty ##* annotation".buildStyledAnnotatedString())
        }
    }
}
