package com.bookmark.bookmarkme

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.bookmark.bookmarkme.di.initKoin
import com.bookmark.bookmarkme.di.platformModule

fun main() {
    initKoin(platformModule) {
        printLogger()
    }
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "BookmarkMe",
        ) {
            App()
        }
    }
}
