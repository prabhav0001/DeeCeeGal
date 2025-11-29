package com.deecode.deewall.navigation

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object Favorites : Screen("favorites")
    data object Detail : Screen("detail")
}
