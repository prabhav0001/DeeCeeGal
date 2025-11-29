package com.deecode.deewall.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.deecode.deewall.Greeting

@Composable
fun DeeWallNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = Screen.Home.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(Screen.Home.route) {
            Greeting(name = "Home Screen")
        }
        composable(Screen.Detail.route) {
            Greeting(name = "Detail Screen")
        }
    }
}
