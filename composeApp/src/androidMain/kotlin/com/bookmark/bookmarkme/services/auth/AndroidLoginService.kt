package com.bookmark.bookmarkme.services.auth

import androidx.credentials.ClearCredentialStateRequest
import androidx.credentials.Credential
import androidx.credentials.CredentialManager
import androidx.credentials.CustomCredential
import androidx.credentials.GetCredentialRequest
import com.bookmark.bookmarkme.core.auth.google.GoogleAccountResponse
import com.bookmark.bookmarkme.core.model.Output
import com.bookmark.bookmarkme.di.AndroidAppScreenContext
import com.bookmark.bookmarkme.di.platform.AppScreenContext
import com.bookmark.bookmarkme.extensions.runCatchingResult
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential

internal class AndroidLoginService(
    private val credentialManager: CredentialManager,
) : LoginService {
    override suspend fun loginWithGoogle(context: AppScreenContext): Output<GoogleAccountResponse> =
        runCatchingResult {
            val credential =
                credentialManager
                    .getCredential(
                        context = (context as AndroidAppScreenContext).activity,
                        request = getCredentialRequest(),
                    ).credential
            handleSignIn(credential)
        }

    override suspend fun loginWithApple(context: AppScreenContext) {
        // Implement Apple login logic here
    }

    override suspend fun logout() {
        credentialManager.clearCredentialState(request = ClearCredentialStateRequest())
    }

    private fun handleSignIn(credential: Credential): GoogleAccountResponse =
        if (credential is CustomCredential &&
            credential.type == GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL
        ) {
            val googleIdTokenCredential = GoogleIdTokenCredential.createFrom(credential.data)
            GoogleAccountResponse(
                token = googleIdTokenCredential.idToken,
                displayName = googleIdTokenCredential.displayName.orEmpty(),
                profileImageUrl = googleIdTokenCredential.profilePictureUri?.toString(),
            )
        } else {
            throw IllegalArgumentException("Unsupported credential type: ${credential.type}")
        }

    private fun getCredentialRequest(): GetCredentialRequest =
        GetCredentialRequest
            .Builder()
            .addCredentialOption(getGoogleIdOption())
            .build()

    private fun getGoogleIdOption(): GetGoogleIdOption =
        GetGoogleIdOption
            .Builder()
            .setFilterByAuthorizedAccounts(false)
            .setAutoSelectEnabled(true)
            .setServerClientId("Add your Google web client id")
            .build()
}
