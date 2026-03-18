package com.bookmark.bookmarkme.di.datalayer

import com.bookmark.bookmarkme.data.repository.onboarding.OnboardingRepository
import com.bookmark.bookmarkme.data.repository.onboarding.OnboardingRepositoryImpl
import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.plugin.module.dsl.single

val dataLayerModule =
    module {
        single<OnboardingRepositoryImpl>() bind OnboardingRepository::class
    }
