package com.bookmark.bookmarkme.ui.navigation.appstart

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.bookmark.bookmarkme.ui.components.login.LoginScreen
import com.bookmark.bookmarkme.ui.components.splash.SplashScreen
import com.bookmark.bookmarkme.ui.components.splash.SplashViewmodel
import com.bookmark.bookmarkme.ui.navigation.login.Login
import com.bookmark.bookmarkme.ui.navigation.splash.Splash
import org.koin.compose.viewmodel.koinViewModel

fun NavGraphBuilder.appStartNavigation(navController: NavHostController) {
    navigation<AppStart>(startDestination = Splash) {
        composable<Splash> {
            SplashScreen(
                splashViewModel = koinViewModel<SplashViewmodel>(),
                navigateToNotificationPreferences = { /* TODO */ },
                navigateToLogin = { navController.navigate(Login) },
                navigateToHome = { /* TODO */ },
            )
        }
        composable<Login> {
            LoginScreen()
        }
    }
}
