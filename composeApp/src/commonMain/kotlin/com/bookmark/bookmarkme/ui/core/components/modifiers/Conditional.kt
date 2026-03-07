package com.bookmark.bookmarkme.ui.core.components.modifiers

import androidx.compose.ui.Modifier

inline fun Modifier.conditional(
    condition: Boolean,
    ifTrue: Modifier.() -> Modifier,
    ifFalse: Modifier.() -> Modifier = { this },
): Modifier =
    if (condition) {
        then(ifTrue(Modifier))
    } else {
        then(ifFalse(Modifier))
    }

inline fun <T> Modifier.conditional(
    checkNotNullValue: T?,
    ifNotNull: Modifier.(T) -> Modifier,
    ifNull: Modifier.() -> Modifier = { this },
): Modifier =
    if (checkNotNullValue != null) {
        then(ifNotNull(Modifier, checkNotNullValue))
    } else {
        then(ifNull(Modifier))
    }
