package com.matheus.fakestore.presentation.main

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.matheus.fakestore.navigation.NavDestinations.Main.MAIN
import com.matheus.fakestore.navigation.Screen
import com.matheus.fakestore.navigation.graphs.mainNavGraph
import com.matheus.fakestore.navigation.graphs.productDetailsNavGraph2
import com.matheus.fakestore.presentation.settings.SettingsViewModel
import com.matheus.fakestore.presentation.utils.BottomNavBar

@Composable
fun MainScreen() {

    var bottomBarVisible by rememberSaveable {
        mutableStateOf(false)
    }

    val settingsViewModel: SettingsViewModel = hiltViewModel()
    val isSystemInDarkTheme by settingsViewModel.isDarkModeEnabled.collectAsStateWithLifecycle(
        initialValue = false
    )
    val useDarkIcons = !isSystemInDarkTheme

    val navController = rememberNavController()

    val navBackStackEntry by navController.currentBackStackEntryAsState()

    bottomBarVisible = when (navBackStackEntry?.destination?.route) {
        Screen.Home.route -> true
        Screen.Favorites.route -> true
        Screen.Cart.route -> true
        Screen.Profile.route -> true
        else -> false
    }

    Scaffold(
        bottomBar = {
            BottomNavBar(
                navController = navController,
                visible = bottomBarVisible,
                isSystemInDarkMode = isSystemInDarkTheme )
        }
    ) { paddingValues ->

        NavHost(
            navController = navController,
            startDestination = MAIN,
            modifier = Modifier.padding(paddingValues)

        ) {

            mainNavGraph(navController, isSystemInDarkTheme)
            productDetailsNavGraph2(navController = navController, isSystemInDarkTheme = isSystemInDarkTheme)
           // recipeDetailsNavGraph2(navController = navController, isSystemInDarkTheme)
            //settingsNavGraph(navController)
//            topCollectionsNavGraph(navController)
//            topAuthorNavGraph(navController)
//            discoverNavGraph(navController)
//            findFriendsNavGraph(navController)
           // authMainNavGraph(navController)
           // settingsNavGraph(navController, isSystemInDarkTheme)
//            collectionDetailsNavGraph(navController, isSystemInDarkTheme)

        }
    }

}