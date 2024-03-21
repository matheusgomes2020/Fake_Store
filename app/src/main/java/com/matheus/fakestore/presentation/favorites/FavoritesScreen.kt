package com.matheus.fakestore.presentation.favorites

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun FavoritesScreen(
    navController: NavController,
    isSystemInDarkTheme: Boolean
){
    Text(text = "Favorites")
}