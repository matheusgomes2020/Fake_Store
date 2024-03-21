package com.matheus.fakestore.presentation.utils
import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.matheus.fakestore.ui.theme.DarkGrey11
import com.matheus.fakestore.ui.theme.GreyApp

@Composable
fun RowType(
    type: RowSearchType,
    selectedd: Boolean,
    //onType: (String) -> Unit,
    onSelected: (Boolean) -> Unit,
    isSystemInDarkTheme: Boolean = androidx.compose.foundation.isSystemInDarkTheme()
){
    var selected = remember {
        mutableStateOf(selectedd)
    }
//    val color = remember {
//    mutableStateOf(
//            Color.White
//    )
//}

    val color = if (isSystemInDarkTheme()) DarkGrey11 else Color.White
    val colorText = if (!isSystemInDarkTheme()) GreyApp else GreyApp

    Surface(
//        onClick = {
//            if (selected.value) {
//                selected.value = false
//                color.value = if (isSystemInDarkTheme ) DarkGrey11 else Color.White
//            } else {
//                selected.value = true
//                color.value = if (isSystemInDarkTheme ) GreenAppDark else GreenApp
//            }
//            //onType(type.label)
//            onSelected(selected.value)
//        },
        color = color,
        modifier = Modifier
            .padding(end = DpDimensions.Small),
        shape = RoundedCornerShape(DpDimensions.Small),
        shadowElevation = 3.dp,
    ) {
        Box(
            modifier = Modifier
                .padding( horizontal = DpDimensions.Normal, vertical = DpDimensions.Small )
        ) {
            Text(text = type.label,
                color = colorText)
        }
    }
}

@Preview
@Composable
fun RowTypePreview() {
    RowType(type = RowSearchType(label = "ww"), selectedd =false , onSelected = {})
}