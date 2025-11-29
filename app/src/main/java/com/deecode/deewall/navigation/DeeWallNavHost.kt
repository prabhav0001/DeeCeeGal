package com.deecode.deewall.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.deecode.deewall.ui.detail.DetailScreen
import com.deecode.deewall.ui.favorites.FavoritesScreen
import com.deecode.deewall.ui.home.HomeScreen

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
            HomeScreen(
                onNavigateToDetail = { navController.navigate(Screen.Detail.route) }
            )
        }
        composable(Screen.Favorites.route) {
            FavoritesScreen()
        }
        composable(Screen.Detail.route) {
            DetailScreen(
                onNavigateUp = { navController.navigateUp() }
            )
        }
    }
}
