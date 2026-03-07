package com.bookmark.bookmarkme.ui.navigation.onboarding

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.bookmark.bookmarkme.ui.components.login.LoginScreen

fun NavGraphBuilder.onboardingNavigation(navController: NavHostController) {
    navigation<Onboarding>(startDestination = Login) {
        composable<Login> {
            LoginScreen()
        }
    }
}
