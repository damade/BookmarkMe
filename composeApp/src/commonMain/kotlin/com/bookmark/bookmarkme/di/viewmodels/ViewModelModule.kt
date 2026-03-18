package com.bookmark.bookmarkme.di.viewmodels

import com.bookmark.bookmarkme.ui.components.splash.SplashViewmodel
import org.koin.dsl.module
import org.koin.plugin.module.dsl.viewModel

val viewModelModule =
    module {
        viewModel<SplashViewmodel>()
    }
