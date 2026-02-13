package com.bookmark.bookmarkme.di.network

import com.bookmark.bookmarkme.di.platform.AppInfoProvider
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val networkModule =
    module {
        single {
            createHttpClient(httpClientEngine = get(), json = get(), appInfoProvider = get())
        }
    }

fun createHttpClient(
    httpClientEngine: HttpClientEngine,
    json: Json,
    appInfoProvider: AppInfoProvider,
) = HttpClient(httpClientEngine) {
    expectSuccess = true

    defaultRequest {
        url(urlString = appInfoProvider.getAppEnvironment().baseUrl)
        contentType(type = ContentType.Application.Json)
    }

    install(ContentNegotiation) {
        json(json)
    }
    install(Logging) {
        logger = Logger.DEFAULT
        level = LogLevel.INFO
    }
}
