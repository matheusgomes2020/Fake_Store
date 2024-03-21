package com.matheus.fakestore.navigation.graphs

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.matheus.fakestore.navigation.NavDestinations.MAIN_APP
import com.matheus.fakestore.navigation.Screen
import com.matheus.fakestore.presentation.main.MainScreen
import com.matheus.fakestore.presentation.utils.slideInVerticallyEnterAnimation
import com.matheus.fakestore.presentation.utils.slideOutVerticallyEnterAnimation

fun NavGraphBuilder.appMainNavGraph(navController: NavController) {
    navigation(
        route = MAIN_APP,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route,
            enterTransition = { slideInVerticallyEnterAnimation() },
            exitTransition = { slideOutVerticallyEnterAnimation() }
             )
        {
            MainScreen()
        }
    }
}