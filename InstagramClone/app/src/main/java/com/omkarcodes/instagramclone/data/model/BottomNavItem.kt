package com.omkarcodes.instagramclone.data.model

import com.omkarcodes.instagramclone.R

sealed class BottomNavItem(val route: String, val icon: Int, val title: String, val isProfile: Boolean = false) {
    object Home: BottomNavItem("home", R.drawable.ic_home,"Home")
    object Explore: BottomNavItem("explore", R.drawable.ic_search,"Explore")
    object Reels: BottomNavItem("reels", R.drawable.ic_reels,"Reels")
    object Activity: BottomNavItem("activity", R.drawable.ic_activity,"Activity")
    object Profile: BottomNavItem("profile", R.drawable.ic_person,"Profile",isProfile = true)
}