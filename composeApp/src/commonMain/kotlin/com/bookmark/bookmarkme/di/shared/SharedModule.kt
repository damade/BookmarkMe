package com.bookmark.bookmarkme.di.shared

import kotlinx.serialization.json.Json
import org.koin.dsl.module

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
    }
