package com.matheus.fakestore.navigation.graphs

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.matheus.fakestore.navigation.NavDestinations.Main.MAIN
import com.matheus.fakestore.navigation.Screen
import com.matheus.fakestore.presentation.cart.CartScreen
import com.matheus.fakestore.presentation.details.DetailsScreen
import com.matheus.fakestore.presentation.favorites.FavoritesScreen
import com.matheus.fakestore.presentation.home.HomeScreen
import com.matheus.fakestore.presentation.profile.ProfileScreen

fun NavGraphBuilder.mainNavGraph(navController: NavController, isSystemInDarkTheme: Boolean) {

    val enterTransitionAnimation = slideInVertically(
        animationSpec = tween(700),
        initialOffsetY = { it }
    )

    val exitTransitionAnimation = slideOutVertically(
        animationSpec = tween(700),
        targetOffsetY = { it }
    )

    navigation(
        startDestination = Screen.Home.route,
        route = MAIN
    ) {

        composable(
            route = Screen.Home.route,
            enterTransition = {
                enterTransitionAnimation
            },
            exitTransition = { exitTransitionAnimation }
        ) {
            HomeScreen(navController = navController, isSystemInDarkTheme = isSystemInDarkTheme)
        }

        composable(route = Screen.Favorites.route,
            enterTransition = { enterTransitionAnimation },
            exitTransition = { exitTransitionAnimation }
        ) {
            //FavoritesScreen(navController = navController, isSystemInDarkTheme = isSystemInDarkTheme)
            DetailsScreen()
        }

        composable(route = Screen.Cart.route,
            enterTransition = { enterTransitionAnimation },
            exitTransition = { exitTransitionAnimation }
        ) {
            CartScreen(navController = navController, isSystemInDarkTheme = isSystemInDarkTheme)
        }

        composable(route = Screen.Profile.route,
            enterTransition = { enterTransitionAnimation },
            exitTransition = { exitTransitionAnimation }
        ) {
            ProfileScreen(navController = navController, isSystemInDarkTheme = isSystemInDarkTheme)
        }
//
//        searchScreenNavGraph( navController = navController )
//        settingsNavGraph(navController = navController, isSystemInDarkTheme = isSystemInDarkTheme)
//        recipeDetailsNavGraph2( navController = navController, isSystemInDarkTheme )
//        topRecipesNavGraph( navController = navController )
//        filtersNavGraph( navController = navController )


    }

}