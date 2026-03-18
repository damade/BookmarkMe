package com.bookmark.bookmarkme.services.auth

import com.bookmark.bookmarkme.core.auth.google.GoogleAccountResponse
import com.bookmark.bookmarkme.core.model.Output
import com.bookmark.bookmarkme.di.platform.AppScreenContext

interface LoginService {
    suspend fun loginWithGoogle(context: AppScreenContext): Output<GoogleAccountResponse>

    suspend fun loginWithApple(context: AppScreenContext)

    suspend fun logout()
}
