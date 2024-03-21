package com.matheus.fakestore.presentation.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.matheus.fakestore.R
import com.matheus.fakestore.ui.theme.GreyApp
import com.matheus.fakestore.ui.theme.White
import com.matheus.fakestore.ui.theme.YellowApp

@Composable
fun SearchBar(
    placeholder: String,
    modifier: Modifier = Modifier,
    searchState: SearchState,
    onSearch: (String) -> Unit = {},
    onSettingsClick: () -> Unit = {}
) {

   Surface(
        shape = RoundedCornerShape(DpDimensions.Small),
        //color = MaterialTheme.colorScheme.onSurface,
        modifier = modifier,
       shadowElevation = 3.dp
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = DpDimensions.Normal)
        ) {
            
            Icon(
                painter = painterResource(id = R.drawable.search),
                contentDescription = "search icon",
               // tint = MaterialTheme.colorScheme.inverseSurface,
                modifier = Modifier.size(DpDimensions.Dp20)
            )
            TextField(
                value = searchState.query, onValueChange = { value ->
                    onSearch(value)
                },
                placeholder = {
                    Text(
                        text = placeholder,
                        style = MaterialTheme.typography.bodyMedium,
                        color = GreyApp
                    )
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    cursorColor = MaterialTheme.colorScheme.inversePrimary
                ),
                modifier = Modifier
                    .weight(1f)
                    .height(DpDimensions.Dp50),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                textStyle = MaterialTheme.typography.bodyMedium
            )
            Card(
                shape = RoundedCornerShape(DpDimensions.Smallest),
                colors = CardDefaults.cardColors(containerColor = YellowApp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 1.dp)
            ) {
                Icon(
                painter = painterResource(id = R.drawable.adjustments),
                contentDescription = "search icon",
                tint = Color.White,
                modifier = Modifier
                    .padding(DpDimensions.Smallest)
                    .size(DpDimensions.Dp20)
                    .clickable {
                        onSettingsClick()

                    }
            )

            }

        }
    }
}