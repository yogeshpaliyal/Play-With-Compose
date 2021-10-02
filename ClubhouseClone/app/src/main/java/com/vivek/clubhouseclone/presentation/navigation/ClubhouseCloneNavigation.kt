package com.vivek.clubhouseclone.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.vivek.clubhouseclone.data.model.leaveRoom
import com.vivek.clubhouseclone.presentation.navigation.Screen.Activity
import com.vivek.clubhouseclone.presentation.navigation.Screen.Home
import com.vivek.clubhouseclone.presentation.navigation.Screen.Profile
import com.vivek.clubhouseclone.presentation.navigation.Screen.Room
import com.vivek.clubhouseclone.presentation.navigation.Screen.Upcoming
import com.vivek.clubhouseclone.presentation.ui.activity.ActivityScreen
import com.vivek.clubhouseclone.presentation.ui.home.HomeScreen
import com.vivek.clubhouseclone.presentation.ui.profile.ProfileScreen
import com.vivek.clubhouseclone.presentation.ui.room.RoomScreen
import com.vivek.clubhouseclone.presentation.ui.upcoming.UpcomingScreen

@Composable
fun ClubhouseCloneNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Home.route) {
        composable(Home.route) {
            HomeScreen(
                navigateToSearch = {},
                navigateToMail = {},
                navigateToCalendar = { navController.navigate(Upcoming.route) },
                navigateToNotification = { navController.navigate(Activity.route) },
                navigateToProfile = { navController.navigate(Profile.route) },
                onRoomClick = { roomId ->
                    navController.navigate("${Room.route}/$roomId")
                }
            )
        }

        composable(
            route = "${Room.route}/{enteredRoomId}",
            arguments = listOf(navArgument("enteredRoomId") { type = NavType.IntType })
        ) { navBackStackEntry ->
            navBackStackEntry.arguments?.getInt("enteredRoomId")?.let { id ->
                RoomScreen(
                    enteredRoomId = id,
                    navigateBack = { navController.popBackStack() },
                    navigateToProfile = { navController.navigate(Profile.route) },
                    onLeaveQuietly = { roomId ->
                        leaveRoom()
                        navController.popBackStack()
                    }
                )
            }
        }

        composable(Upcoming.route) {
            UpcomingScreen(navigateBack = { navController.popBackStack() })
        }

        composable(Activity.route) {
            ActivityScreen(navigateBack = { navController.popBackStack() })
        }

        composable(Profile.route) {
            ProfileScreen(navigateBack = { navController.popBackStack() })
        }
    }
}