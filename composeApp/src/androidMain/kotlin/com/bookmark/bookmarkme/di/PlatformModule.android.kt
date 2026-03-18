package com.bookmark.bookmarkme.di

import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.bookmark.bookmarkme.di.platform.AppInfoProvider
import com.bookmark.bookmarkme.di.platform.PlatformContext
import com.russhwolf.settings.ObservableSettings
import com.russhwolf.settings.SharedPreferencesSettings
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.plugin.module.dsl.single

val platformModule: Module =
    module {
        single<PlatformContext> { AndroidPlatformContext(context = get()) }
        single<AndroidAppInfoProvider>() bind AppInfoProvider::class
        single<HttpClientEngine> { OkHttp.create() }
        single<SharedPreferences> {
            PreferenceManager.getDefaultSharedPreferences(get())
        }
        single<ObservableSettings> { SharedPreferencesSettings(delegate = get()) }
    }
