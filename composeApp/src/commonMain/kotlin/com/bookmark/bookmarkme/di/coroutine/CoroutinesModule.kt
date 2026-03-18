package com.bookmark.bookmarkme.di.coroutine

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.dsl.module

typealias AppCoroutineScope = CoroutineScope

data class AppCoroutineDispatchers(
    val io: CoroutineDispatcher,
    val main: CoroutineDispatcher,
    val default: CoroutineDispatcher,
    val singleThread: CoroutineDispatcher,
)

val coroutinesModule =
    module {
        single {
            AppCoroutineDispatchers(
                io = Dispatchers.IO,
                main = Dispatchers.Main,
                default = Dispatchers.Default,
                singleThread = Dispatchers.IO.limitedParallelism(1),
            )
        }

        single<AppCoroutineScope> {
            CoroutineScope(context = get<AppCoroutineDispatchers>().main + SupervisorJob())
        }
    }
