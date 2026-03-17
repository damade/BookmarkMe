package com.bookmark.bookmarkme.data.repository.notificationpreference

import com.bookmark.bookmarkme.core.preferences.BookmarkPreferences
import com.bookmark.bookmarkme.data.remotesource.api.onboarding.OnboardingApi
import com.bookmark.bookmarkme.data.repository.onboarding.OnboardingRepository
import org.koin.core.annotation.Singleton

@Singleton
internal class NotificationPreferenceRepositoryImpl(
    private val preferences: BookmarkPreferences,
    private val onboardingApi: OnboardingApi,
) : NotificationPreferenceRepository {

    override suspend fun getOnboardingStatus() {
        TODO("Not yet implemented")
    }
}
