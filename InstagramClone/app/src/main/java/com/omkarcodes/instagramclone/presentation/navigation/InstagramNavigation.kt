package com.omkarcodes.instagramclone.presentation.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.omkarcodes.instagramclone.data.model.BottomNavItem
import com.omkarcodes.instagramclone.presentation.ui.home.HomeScreen
import com.omkarcodes.instagramclone.presentation.ui.profile.ProfileScreen

@ExperimentalFoundationApi
@Composable
fun InstagramNavigation() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavBar(navController = navController) }
    ) {
        Box(modifier = Modifier.padding(bottom = it.calculateBottomPadding())){
            NavHost(
                navController = navController,
//            startDestination = BottomNavItem.Home.route,
                startDestination = BottomNavItem.Profile.route,
            ) {
                composable(BottomNavItem.Home.route) {
                    HomeScreen()
                }
                composable(BottomNavItem.Explore.route) {
                    Scaffold {}
                }
                composable(BottomNavItem.Reels.route) {
                    Scaffold {}
                }
                composable(BottomNavItem.Activity.route) {
                    Scaffold {}
                }
                composable(BottomNavItem.Profile.route) {
                    ProfileScreen()
                }
            }
        }
    }
}