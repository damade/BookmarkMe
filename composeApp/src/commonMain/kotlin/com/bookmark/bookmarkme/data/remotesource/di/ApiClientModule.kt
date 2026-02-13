package com.bookmark.bookmarkme.data.remotesource.di

import com.bookmark.bookmarkme.data.remotesource.api.onboarding.OnboardingApi
import org.koin.dsl.module
import org.koin.plugin.module.dsl.single

val apiClientModule =
    module {
        single<OnboardingApi>()
    }
