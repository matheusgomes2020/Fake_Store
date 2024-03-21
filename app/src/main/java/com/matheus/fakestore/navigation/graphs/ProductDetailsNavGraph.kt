package com.matheus.fakestore.navigation.graphs

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.matheus.fakestore.navigation.NavDestinations.RecipeDetails.RECIPE_DETAILS
import com.matheus.fakestore.navigation.NavDestinations.RecipeDetails.RECIPE_DETAILS_MAIN
import com.matheus.fakestore.presentation.details.DetailsScreen

fun NavGraphBuilder.productDetailsNavGraph2(navController: NavController, isSystemInDarkTheme: Boolean) {
    navigation(
        startDestination = RECIPE_DETAILS,
        route = RECIPE_DETAILS_MAIN
    ) {
        composable(
            //route = "$RECIPE_DETAILS/{recipeId}",
            route = RECIPE_DETAILS,
//            arguments = listOf(
//                navArgument( "recipeId" ) {
//                    type = NavType.StringType
//                }
//            )
        ) {
            //navBackStackEntry ->
            DetailsScreen()
//            navBackStackEntry.arguments?.getString("recipeId").let {
//                RecipeDetailScreen(isSystemInDarkTheme = isSystemInDarkTheme, navController = navController)
//            }
        }
    }
}