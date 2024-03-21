package com.matheus.fakestore.presentation.details

import android.content.Context
import android.content.res.Configuration
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import coil.compose.rememberAsyncImagePainter
import com.matheus.fakestore.R
import com.matheus.fakestore.presentation.utils.DpDimensions
import com.matheus.fakestore.presentation.utils.RowSearchType
import com.matheus.fakestore.presentation.utils.RowType
import com.matheus.fakestore.ui.theme.DarkGrey11
import com.matheus.fakestore.ui.theme.GreyApp
import com.matheus.fakestore.ui.theme.GreyBottomBar
import com.matheus.fakestore.ui.theme.YellowApp
import kotlinx.coroutines.flow.collectLatest
import kotlin.math.roundToInt

@Preview
@Composable
fun DetailsScreen(

) {

    Scaffold(
        bottomBar = {

        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(paddingValues)
               // .background(Color.Yellow)
        ) {
            TopContainerTest()
            Details()
            Column(
                verticalArrangement = Arrangement.Bottom,
                modifier = Modifier
                .fillMaxHeight()
                    //.background(Color.Red)
            ) {
                AddToCart()
            }

        }
    }



}

@Preview
@Composable
fun AddToCart() {

    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .padding(DpDimensions.Small)
            .clip(RoundedCornerShape(DpDimensions.Normal))
        //.background(if (isSystemInDarkTheme()) DarkGrey11 else White)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
           // containerColor = if (isSystemInDarkTheme()) GreyBottomBar else GreyBottomBar,
            //containerColor = Yellow,

            modifier = Modifier
                .fillMaxWidth()
                .background(DarkGrey11)
                .clip(RoundedCornerShape(DpDimensions.Normal))
                .graphicsLayer {
                    clip = true
                    shape = RoundedCornerShape(DpDimensions.Normal)
                    shadowElevation = 3f
                }
                .height(75.dp),
           // tonalElevation = 3.dp
        ) {
            Text(
                modifier = Modifier
                   // .align(alignment = Alignment.CenterVertically),
,
                text = "Add to cart",
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp)
        }
    }
}


@Preview
@Composable
fun Details(){
    Column(
        modifier = Modifier
            .padding(DpDimensions.Small)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                    .padding(bottom = DpDimensions.Small)
        ) {
            Text(
                modifier = Modifier
                    .width(250.dp)
                         ,
                text = "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
                fontSize = 22.sp,
                maxLines = 1,
                fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.weight(2f))
            Text(text = "R$109.95",
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold,
                color = YellowApp)
        }
        Row(
            modifier = Modifier
                .padding(bottom = DpDimensions.Small)
        ) {
            Text(text = "⭐⭐⭐⭐⭐")
            Text(text = "5/5(12)")
        }
        Text(text = "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
            fontSize = 15.sp,
            lineHeight = 23.sp,
            color = GreyApp)
        Column(
            modifier = Modifier
                .padding(top = DpDimensions.Small)
        ) {
            Text(text = "Category")
            RowType(type = RowSearchType("Men's Clothing"), selectedd = false, onSelected = {} )
        }
    }

}

@Preview
@Composable
fun TopContainerTest(){
    Surface(
        shape = RoundedCornerShape(
            DpDimensions.Dp30
            //bottomStart = DpDimensions.Dp30, bottomEnd = DpDimensions.Dp30
        ),
        modifier = Modifier
            //.fillMaxSize()
            //.fillMaxWidth()
            .height(450.dp)
            .padding(DpDimensions.Smallest)

    ) {
        Box(
            modifier = Modifier
                .paint(
                    painterResource(id = R.drawable.clockp),
                    contentScale = ContentScale.FillBounds
                )
            // .height(500.dp)
        ) {
            // Box(contentAlignment = Alignment.Center) {
            Row(
                modifier = Modifier
                    .padding(DpDimensions.Normal),
                verticalAlignment = Alignment.CenterVertically
            ) {

                    Icon(tint = YellowApp, painter = painterResource(id = R.drawable.left_chevron_t), contentDescription = ""
                        , modifier = Modifier
                            //.background(Color.White)
                            .padding(DpDimensions.Small)
                            .size(18.dp))

                Spacer(modifier = Modifier.weight(1f))

                    Icon(tint = YellowApp, painter = painterResource(id = R.drawable.heart), contentDescription = ""
                        , modifier = Modifier
                            //.background(Color.White)
                            .padding(DpDimensions.Small)
                            .size(22.dp))

            }
        }
    }

}