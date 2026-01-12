package com.bookmark.bookmarkme

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform