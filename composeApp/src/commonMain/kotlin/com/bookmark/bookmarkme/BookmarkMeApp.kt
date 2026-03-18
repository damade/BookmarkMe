package com.bookmark.bookmarkme

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bookmark.bookmarkme.ui.components.login.LoginScreen
import com.bookmark.bookmarkme.ui.core.components.scaffold.BookmarkScaffold
import com.bookmark.bookmarkme.ui.core.foundation.BookmarkTheme
import com.bookmark.bookmarkme.ui.navigation.appstart.AppStart
import com.bookmark.bookmarkme.ui.navigation.appstart.appStartNavigation
import com.bookmark.bookmarkme.ui.navigation.login.Login

@Composable
fun BookmarkMeApp(navController: NavHostController = rememberNavController()) {
    BookmarkTheme {
        BookmarkScaffold {
            NavHost(
                navController = navController,
                startDestination = AppStart,
                modifier =
                    Modifier
                        .fillMaxSize(),
            ) {
                composable<Login> { LoginScreen() }
                appStartNavigation(navController = navController)
            }
        }
    }
}
