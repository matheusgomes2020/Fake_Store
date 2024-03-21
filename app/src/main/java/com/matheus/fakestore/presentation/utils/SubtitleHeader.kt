package com.matheus.fakestore.presentation.utils

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.matheus.fakestore.R
import com.matheus.fakestore.ui.theme.FakeStoreTheme
import com.matheus.fakestore.ui.theme.YellowApp


@Composable
fun SubtitleHeader(
    modifier: Modifier = Modifier,
    title: String,
    isIconVisible: Boolean,
    isSystemInDarkTheme: Boolean,
    onClick: () -> Unit = {}
) {

//    val systemUiController = rememberSystemUiController()
//    val useDarkIcons = !isSystemInDarkTheme
//
//    SideEffect {
//        systemUiController.setSystemBarsColor(
//            color = if (useDarkIcons)
//                Color.White else DarkGrey11,
//            darkIcons = useDarkIcons
//        )
//    }


    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {

        Text(
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            style = MaterialTheme.typography.headlineMedium,
            color = if (isSystemInDarkTheme()) Color.White else Color.Black,
            modifier = Modifier.weight(1f)
        )

        Text(
            text = "See All",
            color = YellowApp,
            fontSize = 19.sp,
            fontWeight = FontWeight.SemiBold,
            style = MaterialTheme.typography.headlineMedium,
           //modifier = Modifier.weight(1f)
        )


//        IconButton(onClick = onClick) {
//            Icon(
//                painter = painterResource(id = R.drawable.right_arrow),
//                contentDescription = "Right arrow",
//                //tint = MaterialTheme.colorScheme.onPrimary,
//                modifier = Modifier
//                    .size(DpDimensions.Dp20)
//                    .alpha(if (!isIconVisible) 0f else 1f),
//
//
//            )
//        }

    }

}


@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun CategoryHeaderPreview() {
    FakeStoreTheme {
        SubtitleHeader(title = "Em alta", modifier = Modifier.fillMaxWidth(), isIconVisible = true, isSystemInDarkTheme = true)
    }
}