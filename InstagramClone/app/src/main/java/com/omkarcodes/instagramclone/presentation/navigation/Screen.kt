package com.omkarcodes.instagramclone.presentation.navigation

sealed class Screen(val route: String) {

    object HomeScreen : Screen("home")

}