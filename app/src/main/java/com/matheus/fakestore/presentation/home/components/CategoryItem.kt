package com.matheus.fakestore.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.matheus.fakestore.R
import com.matheus.fakestore.presentation.utils.DpDimensions
import com.matheus.fakestore.ui.theme.White
import com.matheus.fakestore.ui.theme.YellowApp

@Preview
@Composable
fun CategoryItem() {
    BoxWithConstraints(
        contentAlignment = Alignment.TopEnd,
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .background(Color.Transparent)    ) {
//        Column(
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(150.dp)
//                .background(White)
//        ) {
////            Image(
////                painterResource(id = R.drawable.shopping_bag )  , contentDescription = "",
////                modifier = Modifier
////                    .size(2.dp)
//////                        .fillMaxSize()
////                    //.padding(DpDimensions.Smallest)
////                    .clip(RoundedCornerShape(DpDimensions.Small)),
////                contentScale = ContentScale.Crop
////            )
//        }



        Surface(
            shape = RoundedCornerShape(DpDimensions.Dp30),
            color = YellowApp,
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(vertical = DpDimensions.Small)
                //.align(Alignment.TopEnd)

            ,
            tonalElevation = 3.dp
        ) {
            Text(
               modifier = Modifier

                    .padding(start = 45.dp, top = 41.dp),
                text = "Eletronics",
                //textAlign = TextAlign.Center,
                fontSize = 31.sp,
                fontWeight = FontWeight.SemiBold,
                color = White)
        }
        Image(
                painterResource(id = R.drawable.smartphone )  , contentDescription = "",
                modifier = Modifier
                    .size(120.dp)
                    .padding(end = DpDimensions.Dp40)
//                        .fillMaxSize()
                    //.padding(DpDimensions.Smallest)
                    .clip(RoundedCornerShape(DpDimensions.Small)),
                contentScale = ContentScale.Crop
            )

//        Column(
//            horizontalAlignment = Alignment.End,
//            modifier = Modifier
//                //.padding(end = 100.dp)
//                .size(30.dp)
//                .background(Color.Red)
//        ) {
//
//        }
        }

    }

