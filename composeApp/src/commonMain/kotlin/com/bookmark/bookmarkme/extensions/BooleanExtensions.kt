package com.bookmark.bookmarkme.extensions

val Boolean.Companion.values: List<Boolean>
    get() = listOf(true, false)

inline fun Boolean.Companion.forEach(block: (Boolean) -> Unit) {
    values.forEach {
        block(it)
    }
}
