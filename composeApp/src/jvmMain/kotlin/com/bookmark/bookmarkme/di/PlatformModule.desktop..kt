package com.bookmark.bookmarkme.di

import com.bookmark.bookmarkme.di.platform.AppInfoProvider
import com.bookmark.bookmarkme.di.platform.PlatformContext
import com.russhwolf.settings.ObservableSettings
import com.russhwolf.settings.PreferencesSettings
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.java.Java
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.plugin.module.dsl.single
import java.util.prefs.Preferences

val platformModule: Module =
    module {
        single<DesktopPlatformContext>() bind PlatformContext::class
        single<DesktopAppInfoProvider>() bind AppInfoProvider::class
        single<HttpClientEngine> { Java.create() }
        single<ObservableSettings> { PreferencesSettings(delegate = get()) }
        single<Preferences> { Preferences.userRoot().node("app.bookmarkme") }
    }
