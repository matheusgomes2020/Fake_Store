package com.matheus.fakestore.presentation.utils

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Magenta
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.matheus.fakestore.navigation.bottomNavScreens
import com.matheus.fakestore.ui.theme.FakeStoreTheme
import com.matheus.fakestore.ui.theme.Grey13
import com.matheus.fakestore.ui.theme.Grey75
import com.matheus.fakestore.ui.theme.GreyBottomBar
import com.matheus.fakestore.ui.theme.YellowApp


@Composable
fun BottomNavBar(
    modifier: Modifier = Modifier,
    navController: NavController,
    visible: Boolean = true,
    isSystemInDarkMode: Boolean
) {
    AnimatedVisibility(
        visible = visible,
        enter = slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { it })
    ) {
        Column(
            modifier = Modifier
                .padding(DpDimensions.Small)
                //.background(if (isSystemInDarkTheme()) DarkGrey11 else White)
        ) {
            NavigationBar(
                containerColor = if (isSystemInDarkTheme()) GreyBottomBar else GreyBottomBar,
                //containerColor = Yellow,

                modifier = Modifier
                    .fillMaxWidth()
                    //.background(Blue)
                    .graphicsLayer {
                        clip = true
                        shape = RoundedCornerShape(DpDimensions.Dp20)
                        shadowElevation = 3f
                    }
                    .height(75.dp),
                tonalElevation = 3.dp
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                bottomNavScreens.forEach { screen ->
                    val selected =
                        currentDestination?.hierarchy?.any { it.route == screen.route } == true
                    NavigationBarItem(
                        selected = selected,
                        modifier = Modifier.background(if (isSystemInDarkTheme()) GreyBottomBar else GreyBottomBar),
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = {
                            Icon(
                                painter = painterResource(id = screen.icon),
                                contentDescription = null,
                                tint = if (selected) YellowApp else Grey75
                            )
                        },
//                        label = {
//                            Text(
//                                text = stringResource(id = screen.label),
//                                style = MaterialTheme.typography.bodySmall,
//                                color =  if (selected) YellowApp else YellowApp
//                            )
//                        },
                        colors = NavigationBarItemDefaults.colors(
                            indicatorColor = if (isSystemInDarkTheme()) GreyBottomBar else GreyBottomBar,

                        )
                    )
                }
            }
        }
    }
}


@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun BottomNavBarPreview() {
    FakeStoreTheme {
        BottomNavBar(navController = rememberNavController(), isSystemInDarkMode = true)
    }
}
