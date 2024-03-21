package com.matheus.fakestore.navigation.graphs

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.matheus.fakestore.navigation.NavDestinations.Splash.SPLASH
import com.matheus.fakestore.navigation.NavDestinations.Splash.SPLASH_MAIN
import com.matheus.fakestore.presentation.splash.SplashScreen
import com.matheus.fakestore.presentation.utils.slideInVerticallyEnterAnimation
import com.matheus.fakestore.presentation.utils.slideOutVerticallyEnterAnimation

fun NavGraphBuilder.splashNavGraph(navController: NavController) {
    navigation(
        startDestination = SPLASH,
        route = SPLASH_MAIN
    ) {

        composable(
            route = SPLASH,
            enterTransition = { slideInVerticallyEnterAnimation() },
            exitTransition = { slideOutVerticallyEnterAnimation() }
        ) {
            SplashScreen(navController = navController)
        }



    }
}