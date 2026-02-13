package com.bookmark.bookmarkme.di

import com.bookmark.bookmarkme.di.platform.AppInfoProvider
import com.bookmark.bookmarkme.di.platform.PlatformContext
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.java.Java
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.plugin.module.dsl.single

val platformModule: Module = module {
    single<DesktopPlatformContext>() bind PlatformContext::class
    single<DesktopAppInfoProvider>() bind AppInfoProvider::class
    single<HttpClientEngine> { Java.create() }
}
