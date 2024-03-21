package com.matheus.fakestore.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.matheus.fakestore.navigation.NavDestinations.Auth.AUTH
import com.matheus.fakestore.navigation.NavDestinations.Auth.AUTHENTICATION
import com.matheus.fakestore.presentation.auth.AuthMainScreen
import com.matheus.fakestore.presentation.utils.slideInVerticallyEnterAnimation
import com.matheus.fakestore.presentation.utils.slideOutVerticallyEnterAnimation

fun NavGraphBuilder.authMainNavGraph(navController: NavController) {
    navigation(
        route = AUTH,
        startDestination = AUTHENTICATION
    ) {
        composable(route = AUTHENTICATION,
            enterTransition = { slideInVerticallyEnterAnimation() },
            exitTransition = { slideOutVerticallyEnterAnimation() }) {
            AuthMainScreen()
        }
    }
}