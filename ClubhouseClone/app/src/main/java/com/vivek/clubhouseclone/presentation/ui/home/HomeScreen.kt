package com.vivek.clubhouseclone.presentation.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.FabPosition
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.vivek.clubhouseclone.data.model.getRooms
import com.vivek.clubhouseclone.data.model.rooms
import com.vivek.clubhouseclone.presentation.navigation.Screen.Home.TopAppBarAction.Calendar
import com.vivek.clubhouseclone.presentation.navigation.Screen.Home.TopAppBarAction.Mail
import com.vivek.clubhouseclone.presentation.navigation.Screen.Home.TopAppBarAction.Notification
import com.vivek.clubhouseclone.presentation.ui.home.components.BottomBarWithGradient
import com.vivek.clubhouseclone.presentation.ui.home.components.Fab
import com.vivek.clubhouseclone.presentation.ui.home.components.RoomItem
import com.vivek.clubhouseclone.presentation.ui.home.components.TopBar
import com.vivek.clubhouseclone.presentation.ui.home.components.UpcomingEvents

@Composable
fun HomeScreen(
    navigateToSearch: () -> Unit,
    navigateToMail: () -> Unit,
    navigateToCalendar: () -> Unit,
    navigateToNotification: () -> Unit,
    navigateToProfile: () -> Unit,
    onRoomClick: (Int) -> Unit
) {
    getRooms()

    val rooms = rooms.value

    Scaffold(
        topBar = {
            TopBar(
                onActionClick = { action ->
                    when (action) {
                        Calendar -> navigateToCalendar()
                        Mail -> navigateToMail()
                        Notification -> navigateToNotification()
                    }
                },
                navigateToSearch = navigateToSearch,
                navigateToProfile = navigateToProfile
            )
        },
        floatingActionButton = { Fab(onClick = {}) },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        bottomBar = { BottomBarWithGradient() }
    ) { scaffoldPadding ->
        LazyColumn(
            modifier = Modifier.padding(12.dp)
        ) {
            // Upcoming Events
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { navigateToCalendar() },
                    shape = RoundedCornerShape(20.dp),
                    elevation = 0.dp,
                    backgroundColor = MaterialTheme.colors.primaryVariant
                ) {
                    UpcomingEvents()
                }
                Spacer(modifier = Modifier.size(16.dp))
            }

            // Rooms
            items(rooms) { room ->
                RoomItem(room = room, onRoomClick = { onRoomClick(it) })
                Spacer(modifier = Modifier.size(16.dp))
            }
        }
    }
}

















