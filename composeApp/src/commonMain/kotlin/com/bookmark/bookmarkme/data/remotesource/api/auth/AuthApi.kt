package com.bookmark.bookmarkme.data.remotesource.api.auth

import io.ktor.client.HttpClient
import org.koin.core.annotation.Singleton

@Singleton
class AuthApi(
    private val client: HttpClient,
)
//    suspend fun createUserAccount(
//        createAccountRequestDto: CreateAccountRequestDto,
//    ): CreateAccountDto? {
//        val response = client.post(urlString = "auth/signup") {
//            setBody(createAccountRequestDto)
//        }
//
//        return response.toDto()
//    }
//
//    suspend fun loginUser(
//        loginRequestDto: LoginRequestDto,
//    ): LoginDto? {
//        val response = client.post(urlString = "auth/login") {
//            setBody(loginRequestDto)
//        }
//
//        return response.toDto()
//    }
// }
