package com.bookmark.bookmarkme

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() =
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "BookmarkMe",
        ) {
            App()
        }
    }
