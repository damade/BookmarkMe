package com.bookmark.bookmarkme.data.repository.onboarding

import com.bookmark.bookmarkme.core.preferences.BookmarkPreferences
import com.bookmark.bookmarkme.data.remotesource.api.onboarding.OnboardingApi
import org.koin.core.annotation.Singleton

@Singleton
internal class OnboardingRepositoryImpl(
    private val preferences: BookmarkPreferences,
    private val onboardingApi: OnboardingApi,
) : OnboardingRepository {
    override suspend fun isOnboardingCompleted(): Boolean = !preferences.isFirstLaunch.get()
}
