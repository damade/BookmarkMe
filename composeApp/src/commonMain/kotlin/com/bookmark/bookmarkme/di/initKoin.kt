package com.bookmark.bookmarkme.di

import com.bookmark.bookmarkme.data.remotesource.di.apiClientModule
import com.bookmark.bookmarkme.di.network.networkModule
import com.bookmark.bookmarkme.di.shared.sharedModule
import org.koin.core.KoinApplication
import org.koin.core.context.GlobalContext.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.includes

fun initKoin(config: KoinAppDeclaration? = null): KoinApplication =
    startKoin {
        includes(config)
        modules(
            sharedModule,
            networkModule,
            apiClientModule,
        )
    }
