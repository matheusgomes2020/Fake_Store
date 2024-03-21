package com.matheus.fakestore.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.matheus.fakestore.R
import com.matheus.fakestore.navigation.NavDestinations.SearchRecipes.SEARCH_RECIPES
import com.matheus.fakestore.presentation.home.components.CategoryItem
import com.matheus.fakestore.presentation.home.components.HomeProductItem
import com.matheus.fakestore.presentation.home.components.HomeProductItemPreview
import com.matheus.fakestore.presentation.utils.CustomPadding
import com.matheus.fakestore.presentation.utils.DpDimensions
import com.matheus.fakestore.presentation.utils.MainAppBar
import com.matheus.fakestore.presentation.utils.RowType
import com.matheus.fakestore.presentation.utils.SearchBar
import com.matheus.fakestore.presentation.utils.SearchState
import com.matheus.fakestore.presentation.utils.SubtitleHeader
import com.matheus.fakestore.presentation.utils.mealTypes

@Composable
fun HomeScreen(
    navController: NavController,
    isSystemInDarkTheme: Boolean,
    viewModel: HomeViewModel = hiltViewModel()
){

    val state = viewModel.state.value

    Scaffold(
        topBar = {
            MainAppBar(icon = R.drawable.four_dots,
                icon1 = R.drawable.bell_ring, title = "" , imageUrl = "",
                onSearchClick = {
                    navController.navigate( SEARCH_RECIPES)
                })
        }
    ) { paddingValues ->
        Column(

            modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .fillMaxSize()

        ) {
            state.products?.let {
                //Text(text = state.toString())
            }
            PopularProducts(navController = navController, state)
        }
    }
}

@Composable
fun PopularProducts(navController: NavController, state: ProductsHitState){
    CustomPadding(
        verticalPadding = 0.dp,
        horizontalPadding = DpDimensions.Dp20
    ) {
        Spacer(modifier = Modifier.height(DpDimensions.Normal))
        SearchBar(placeholder = "Search product", searchState = SearchState() ) {}
        Spacer(modifier = Modifier.height(DpDimensions.Normal))
        LazyRow(contentPadding = PaddingValues(horizontal = DpDimensions.Smallest, vertical = DpDimensions.Normal),
        ){
            items( mealTypes ) { type ->
                RowType(  type, false, {},
                    //  {}
                )
            }
        }
        Spacer(modifier = Modifier.height(DpDimensions.Normal))
        CategoryItem()
        Spacer(modifier = Modifier.height(DpDimensions.Normal))
        SubtitleHeader(title = "Popular Products", isIconVisible = false, isSystemInDarkTheme = false )
        Spacer(modifier = Modifier.height(DpDimensions.Normal))
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(DpDimensions.Smallest),
            modifier = Modifier,
            contentPadding = PaddingValues(horizontal = 1.dp, vertical = 1.dp)
        ) {
            items(state.products) { product ->
                HomeProductItem(navController = navController, product )
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen(navController = rememberNavController(), isSystemInDarkTheme = false)
}

@Preview
@Composable
fun HomeScreenPreviewDark(){
    HomeScreen(navController = rememberNavController(), isSystemInDarkTheme = true)
}

@Preview
@Composable
fun PopularProductsPreview(){
    CustomPadding(
        verticalPadding = 0.dp,
        horizontalPadding = DpDimensions.Dp20
    ) {
        Spacer(modifier = Modifier.height(DpDimensions.Normal))
        SearchBar(placeholder = "Search product", searchState = SearchState() ) {}
        Spacer(modifier = Modifier.height(DpDimensions.Normal))
        LazyRow(contentPadding = PaddingValues(horizontal = DpDimensions.Smallest, vertical = DpDimensions.Normal),
        ){
            items( mealTypes ) { type ->
                RowType(  type, false, {},
                    //  {}
                )
            }
        }
        Spacer(modifier = Modifier.height(DpDimensions.Normal))
        CategoryItem()
        Spacer(modifier = Modifier.height(DpDimensions.Normal))
        SubtitleHeader(title = "Popular Products", isIconVisible = false, isSystemInDarkTheme = false )
        Spacer(modifier = Modifier.height(DpDimensions.Normal))
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(DpDimensions.Smallest),
            modifier = Modifier,
            contentPadding = PaddingValues(horizontal = 1.dp, vertical = 1.dp)
        ) {
            items(3) {
                HomeProductItemPreview()
            }
        }
    }
}