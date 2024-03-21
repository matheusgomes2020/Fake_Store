package com.matheus.fakestore.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.matheus.fakestore.R

sealed class Screen( val route: String, @StringRes val label: Int, @DrawableRes val icon: Int ) {
    object Home: Screen(HOME, R.string.home, R.drawable.home)
    object Favorites: Screen(FAVORITES, R.string.favorites, R.drawable.heart)
    object Cart: Screen(CART, R.string.cart, R.drawable.shopping_bag)
    object Profile: Screen(PROFILE, R.string.profile, R.drawable.user)

    companion object {
        const val HOME = "home"
        const val FAVORITES = "favorites"
        const val CART = "cart"
        const val PROFILE = "profile"
    }
}

val bottomNavScreens = listOf(
    Screen.Home,
    Screen.Favorites,
    Screen.Cart,
    Screen.Profile
)
