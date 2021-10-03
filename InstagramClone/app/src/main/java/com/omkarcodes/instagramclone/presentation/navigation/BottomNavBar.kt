package com.omkarcodes.instagramclone.presentation.navigation

import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.omkarcodes.instagramclone.data.model.BottomNavItem

@Composable
fun BottomNavBar(
    navController: NavController
) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Explore,
        BottomNavItem.Reels,
        BottomNavItem.Activity,
        BottomNavItem.Profile,
    )
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background,
        contentColor = MaterialTheme.colors.onBackground
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach {
                BottomNavigationItem(
                    icon = {
                        Icon(
                            painter = painterResource(id = it.icon),
                            contentDescription = it.title,
                            // because reels icon is little bit large
                            modifier =  Modifier.size(if(it == BottomNavItem.Reels) 23.dp else 28.dp)) },
                    label = null,
                    selectedContentColor = MaterialTheme.colors.onBackground,
                    unselectedContentColor = Color(0xFFAEAFAF),
                    selected = currentRoute == it.route,
                    onClick = {
                        navController.navigate(it.route)
                    },
                )
        }
    }
}