package com.matheus.fakestore.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.matheus.core.domain.model.Product
import com.matheus.fakestore.R
import com.matheus.fakestore.navigation.NavDestinations
import com.matheus.fakestore.presentation.utils.DpDimensions
import com.matheus.fakestore.ui.theme.White
import com.matheus.fakestore.ui.theme.YellowApp


@Composable
fun HomeProductItem(
    navController: NavController,
    product: Product
) {

    Card(
        shape = RoundedCornerShape(DpDimensions.Smallest),
        colors = CardDefaults.cardColors(containerColor = White),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        ),
        modifier = Modifier
            .clickable {
                navController.navigate(NavDestinations.RecipeDetails.RECIPE_DETAILS)
            }
            
    ) {
        Column(
            modifier = Modifier
            .padding(2.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .width(172.dp)
                    .height(172.dp)
                    .clip(
                        RoundedCornerShape(
                            topStart = DpDimensions.Smallest,
                            topEnd = DpDimensions.Smallest
                        )
                    )
                    //.background(Color.LightGray)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(
                        model = product.image
                    )  , contentDescription = "",
                    modifier = Modifier
                        .size(120.dp)
//                        .fillMaxSize()
                        //.padding(DpDimensions.Smallest)
                        .clip(RoundedCornerShape(DpDimensions.Small)),
                    contentScale = ContentScale.Crop
                )
            }
            Row(
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier
                    //.width(172.dp)
                    .padding(start = 2.dp, top = DpDimensions.Small, bottom = DpDimensions.Small)
            ) {
                Column(

                    modifier = Modifier
//                        .padding(vertical = DpDimensions.Smallest
//                        //    , horizontal = 2.dp
//                        )
                        // .size(100.dp)
                        .clip(RoundedCornerShape(DpDimensions.Smallest))
                    //.background(Color.Magenta)
                ) {

                    Text(
                        modifier = Modifier
                            .width(150.dp),
                        text = product.title,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        maxLines = 1
                    )

                    Text(
                        text = product.price,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = YellowApp
                    )
                }

                    Icon(
                        imageVector = Icons.Default.Add,
                        //painterResource(R.drawable.home),
                        contentDescription = null,
                        tint = White,
                        modifier = Modifier
                            .size(18.dp)
                            .clip(RoundedCornerShape(DpDimensions.Smallest))
                            .background(Color.Black)
                          //  .align(alignment = )
                    )

//                Icon(painter = R.drawable.home,
//                    modifier = Modifier
//                        .size(15.dp)
//                        .clip(RoundedCornerShape(DpDimensions.Smallest))
//                        //.background(Color.Red)
//                ) {
//
//                }
            }

        }


    }
}

@Preview
@Composable
fun HomeProductItemPreview() {
    Card(
        shape = RoundedCornerShape(DpDimensions.Smallest),
        colors = CardDefaults.cardColors(containerColor = White),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        )

    ) {
        Column(
            modifier = Modifier
                .padding(2.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .width(172.dp)
                    .height(172.dp)
                    .clip(
                        RoundedCornerShape(
                            topStart = DpDimensions.Smallest,
                            topEnd = DpDimensions.Smallest
                        )
                    )
                //.background(Color.LightGray)
            ) {
                Image(
                    painterResource(id = R.drawable.clockp )  , contentDescription = "",
                    modifier = Modifier
                        .size(120.dp)
//                        .fillMaxSize()
                        //.padding(DpDimensions.Smallest)
                        .clip(RoundedCornerShape(DpDimensions.Small)),
                    contentScale = ContentScale.Crop
                )
            }
            Row(
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier
                    //.width(172.dp)
                    .padding(start = 2.dp, top = DpDimensions.Small, bottom = DpDimensions.Small)
            ) {
                Column(

                    modifier = Modifier
//                        .padding(vertical = DpDimensions.Smallest
//                        //    , horizontal = 2.dp
//                        )
                        // .size(100.dp)
                        .clip(RoundedCornerShape(DpDimensions.Smallest))
                    //.background(Color.Magenta)
                ) {

                    Text(
                        text = "B1 Analog Clock",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )

                    Text(
                        text = "R$250",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = YellowApp
                    )
                }

                Icon(
                    imageVector = Icons.Default.Add,
                    //painterResource(R.drawable.home),
                    contentDescription = null,
                    tint = White,
                    modifier = Modifier
                        .size(18.dp)
                        .clip(RoundedCornerShape(DpDimensions.Smallest))
                        .background(Color.Black)
                    //  .align(alignment = )
                )

//                Icon(painter = R.drawable.home,
//                    modifier = Modifier
//                        .size(15.dp)
//                        .clip(RoundedCornerShape(DpDimensions.Smallest))
//                        //.background(Color.Red)
//                ) {
//
//                }
            }

        }


    }
}