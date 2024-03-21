package com.matheus.fakestore.presentation.onboarding

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.matheus.fakestore.R

data class OnBoarding(
    @DrawableRes val image: Int,
    @StringRes val title: Int
)


val onBoardingItems = listOf(
    OnBoarding(image = R.drawable.user, title = R.string.favorites_onboarding),
    OnBoarding(image = R.drawable.shopping_bag, title = R.string.search_onboarding),
    OnBoarding(image = R.drawable.heart, title = R.string.ingredients_onboarding),
)
