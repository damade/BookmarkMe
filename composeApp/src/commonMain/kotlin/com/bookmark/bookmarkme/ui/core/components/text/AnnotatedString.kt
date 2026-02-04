package com.bookmark.bookmarkme.ui.core.components.text

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import com.bookmark.bookmarkme.ui.core.components.text.AnnotatedStringDefaults.LINK_ANNOTATION_TAG
import kotlin.collections.filter
import kotlin.collections.forEach
import kotlin.collections.forEachIndexed
import kotlin.collections.map
import kotlin.collections.runningFold
import kotlin.collections.windowed
import kotlin.text.filter
import kotlin.text.forEachIndexed
import kotlin.text.map
import kotlin.text.substring
import kotlin.to

enum class AnnotatedStringMarker(val value: Char) {
    LINK('#'),
    BOLD('*'),
}

object AnnotatedStringDefaults {
    const val LINK_ANNOTATION_TAG = "URL"

    val linkStyle: SpanStyle
        @Composable get() = SpanStyle(color = MaterialTheme.colorScheme.primary)
    val boldStyle: SpanStyle
        @Composable get() = SpanStyle(fontWeight = FontWeight.Bold)

    val defaultStyleMap: Map<AnnotatedStringMarker, SpanStyle>
        @Composable get() = mapOf(
            AnnotatedStringMarker.LINK to linkStyle,
            AnnotatedStringMarker.BOLD to boldStyle,
        )
}

@Composable
fun String.buildStyledAnnotatedString(
    spanStyleMap: Map<AnnotatedStringMarker, SpanStyle> = AnnotatedStringDefaults.defaultStyleMap,
    linkOnClickListener: (linkIndex: Int) -> Unit = { },
): AnnotatedString = this.buildStyledAnnotatedStringWithLinkText(
    spanStyleMap = spanStyleMap,
    linkOnClickListenerWithText = { index, _ -> linkOnClickListener(index) },
)

@Composable
fun String.buildStyledAnnotatedStringWithLinkText(
    spanStyleMap: Map<AnnotatedStringMarker, SpanStyle> = AnnotatedStringDefaults.defaultStyleMap,
    linkOnClickListenerWithText: (linkIndex: Int, linkText: String) -> Unit = { _, _ -> },
): AnnotatedString = buildAnnotatedString {
    val markers = spanStyleMap.keys.map { it.value }
    val markerCount = map { if (it in markers) 1 else 0 }
        .runningFold(0) { acc, i -> acc + i }

    val stringWithoutMarkers = filter { it !in markers }

    append(stringWithoutMarkers)

    spanStyleMap.forEach { spanStyleEntry ->
        val marker = spanStyleEntry.key
        val markerChar = spanStyleEntry.key.value
        val style = spanStyleEntry.value
        val markerIndices = indicesOf(markerChar).map { it - markerCount[it] }

        markerIndices.windowed(size = 2, step = 2)
            .filter { it.size == 2 }
            .forEach { markerIndexGroup ->
                addStyle(
                    style = style,
                    start = markerIndexGroup[0],
                    end = markerIndexGroup[1],
                )
            }

        if (marker == AnnotatedStringMarker.LINK) {
            markerIndices.windowed(size = 2, step = 2)
                .filter { it.size == 2 }
                .forEachIndexed { markerIndexGroupIdx, markerIndexGroup ->
                    val start = markerIndexGroup[0]
                    val end = markerIndexGroup[1]
                    val clickedSubstring = stringWithoutMarkers.substring(start, end)
                    addLink(
                        LinkAnnotation.Clickable(
                            tag = LINK_ANNOTATION_TAG,
                            linkInteractionListener = {
                                linkOnClickListenerWithText(markerIndexGroupIdx, clickedSubstring)
                            },
                        ),
                        start = start,
                        end = end,
                    )
                }
        }
    }
}

private fun String.indicesOf(char: Char): List<Int> {
    val indices = mutableListOf<Int>()
    forEachIndexed { index, ch -> if (ch == char) indices.add(index) }
    return indices
}
