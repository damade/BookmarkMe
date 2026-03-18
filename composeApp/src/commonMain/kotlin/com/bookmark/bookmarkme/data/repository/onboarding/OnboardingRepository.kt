package com.bookmark.bookmarkme.data.repository.onboarding

interface OnboardingRepository {
    suspend fun isOnboardingCompleted(): Boolean
}
