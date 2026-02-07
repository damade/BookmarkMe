package com.bookmark.bookmarkme.ui.model

import org.jetbrains.compose.resources.PluralStringResource
import org.jetbrains.compose.resources.StringResource
import kotlin.collections.toList

sealed interface StringHolder {
    data class Value(
        val value: String,
    ) : StringHolder

    data class Resource(
        val resId: StringResource,
    ) : StringHolder

    data class ParametrizedResource(
        val resId: StringResource,
        val formatArgs: List<String>,
    ) : StringHolder

    /**
     * This type allows formatArgs of mixed types of String, Doubles and StringResource only,
     * Passing unsupported argument types or mismatched arguments may lead to IllegalArgumentException at runtime
     */
    data class ParametrizedMixedResource(
        val resId: StringResource,
        val formatArgs: List<Any>,
    ) : StringHolder

    data class Plural(
        val resId: PluralStringResource,
        val count: Int,
        val formatArgs: List<String>,
    ) : StringHolder

    companion object
}

fun StringHolder.Companion.parametrizedResource(
    resId: StringResource,
    vararg formatArgs: String,
): StringHolder = StringHolder.ParametrizedResource(resId, formatArgs.toList())

fun StringHolder.Companion.pluralResource(
    resId: PluralStringResource,
    count: Int,
    vararg formatArgs: String,
): StringHolder = StringHolder.Plural(resId, count, formatArgs.toList())

fun String.toStringHolder(): StringHolder = StringHolder.Value(this)

fun StringResource.toStringHolder(): StringHolder = StringHolder.Resource(resId = this)
