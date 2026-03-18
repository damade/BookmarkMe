package com.bookmark.bookmarkme.di.shared

import com.bookmark.bookmarkme.core.preferences.BookmarkPreferences
import com.bookmark.bookmarkme.core.preferences.BookmarkPreferencesImpl
import kotlinx.serialization.json.Json
import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.plugin.module.dsl.single

val sharedModule =
    module {
        single {
            Json {
                isLenient = true
                ignoreUnknownKeys = true
                useAlternativeNames = false
                prettyPrint = true
            }
        }

        single<BookmarkPreferencesImpl>() bind BookmarkPreferences::class
    }
