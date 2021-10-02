package com.vivek.clubhouseclone.presentation.navigation

import com.vivek.clubhouseclone.R

sealed class Screen(val route: String) {
    object Home : Screen(route = "home") {
        val actions: List<TopAppBarAction> = listOf(
            TopAppBarAction.Mail,
            TopAppBarAction.Calendar,
            TopAppBarAction.Notification,
        )

        sealed class TopAppBarAction(val icon: Int, val description: String) {
            object Mail : TopAppBarAction(icon = R.drawable.ic_mail, description = "Mail")
            object Calendar :
                TopAppBarAction(icon = R.drawable.ic_calendar, description = "Calendar")

            object Notification :
                TopAppBarAction(icon = R.drawable.ic_notification, description = "Notification")
        }
    }

    object Room : Screen(route = "room") {
        val actions: List<TopAppBarAction> = listOf(TopAppBarAction.Document)

        sealed class TopAppBarAction(val icon: Int, val description: String) {
            object Document :
                TopAppBarAction(icon = R.drawable.ic_document, description = "Document")
        }
    }

    object Upcoming : Screen(route = "upcoming")

    object Activity : Screen(route = "activity")

    object Profile : Screen(route = "profile")
}













