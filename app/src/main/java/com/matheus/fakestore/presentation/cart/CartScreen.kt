package com.matheus.fakestore.presentation.cart

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun CartScreen(
    navController: NavController,
    isSystemInDarkTheme: Boolean
){
    Text(text = "Cart")
}