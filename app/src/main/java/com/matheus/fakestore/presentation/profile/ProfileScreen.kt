package com.matheus.fakestore.presentation.profile

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun ProfileScreen(
    navController: NavController,
    isSystemInDarkTheme: Boolean
){
    Text(text = "Profile")
}