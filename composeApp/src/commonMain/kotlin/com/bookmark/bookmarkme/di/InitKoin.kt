package com.bookmark.bookmarkme.di

import com.bookmark.bookmarkme.di.coroutine.coroutinesModule
import com.bookmark.bookmarkme.di.datalayer.dataLayerModule
import com.bookmark.bookmarkme.di.network.networkModule
import com.bookmark.bookmarkme.di.shared.sharedModule
import com.bookmark.bookmarkme.di.viewmodels.viewModelModule
import org.koin.core.KoinApplication
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.includes

fun initKoin(
    vararg platformModules: Module,
    config: KoinAppDeclaration? = null,
): KoinApplication =
    startKoin {
        includes(config)
        modules(
            sharedModule,
            networkModule,
            coroutinesModule,
            viewModelModule,
            dataLayerModule,
            *platformModules,
        )
    }
