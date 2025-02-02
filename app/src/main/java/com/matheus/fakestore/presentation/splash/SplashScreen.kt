package com.matheus.fakestore.presentation.splash

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.matheus.fakestore.R
import com.matheus.fakestore.navigation.NavDestinations
import com.matheus.fakestore.presentation.settings.SettingsViewModel
import com.matheus.fakestore.ui.theme.DarkGrey11
import com.matheus.fakestore.ui.theme.FakeStoreTheme
import com.matheus.fakestore.ui.theme.White
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    //val systemUiController = rememberSystemUiController()
    val settingsViewModel: SettingsViewModel = hiltViewModel()
    val isDarkModeEnabled by settingsViewModel.isDarkModeEnabled.collectAsStateWithLifecycle(initialValue = false)
    val useDarkIcons = !isDarkModeEnabled

   // val viewModel: SplashViewModel = hiltViewModel()
    //val isLoggedIn by viewModel.isLoggedIn.collectAsStateWithLifecycle(initialValue = false)

    val isOnboardingEnabled by settingsViewModel.isOnboardingEnabled.collectAsStateWithLifecycle(
        initialValue = false
    )

//    SideEffect {
//        systemUiController.setSystemBarsColor(
//            color = if (useDarkIcons)
//                White else DarkGrey11,
//            darkIcons = useDarkIcons
//        )
//    }

    LaunchedEffect(key1 = true) {
        delay(3_000)
        //delay(100)
        navController.navigate(
            //NavDestinations.MAIN_APP
            if (!isOnboardingEnabled) NavDestinations.Auth.AUTH
            else NavDestinations.MAIN_APP
        ) {
            popUpTo(NavDestinations.Splash.SPLASH_MAIN) {
                inclusive = true
            }
        }
    }


    Surface(
        modifier = Modifier
            .fillMaxSize()
            //.background(color = MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.yumlogoo),
                    contentDescription = "App logo",
                    modifier = Modifier.size(200.dp)
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = stringResource(id = R.string.app_name),
                    fontSize = 30.sp,
                    style = MaterialTheme.typography.headlineLarge,
                    color = if (isSystemInDarkTheme()) Color.White else Color.DarkGray
                )
            }

//            BallSpinFadeLoaderProgressIndicator(
//                color = MaterialTheme.colorScheme.onPrimary,
//                modifier = Modifier.size(50.dp)
//            )

        }
    }
}

@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun SplashScreenPreview() {
    FakeStoreTheme {
        SplashScreen(rememberNavController())
    }
}