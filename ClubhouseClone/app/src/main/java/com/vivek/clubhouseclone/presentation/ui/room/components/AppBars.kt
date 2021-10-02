package com.vivek.clubhouseclone.presentation.ui.room.components

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.vivek.clubhouseclone.R
import com.vivek.clubhouseclone.presentation.components.ProfileSquircle
import com.vivek.clubhouseclone.presentation.navigation.Screen

@Composable
fun TopBar(
    navigateBack: () -> Unit,
    navigateToProfile: () -> Unit
) {
    TopAppBar(
        modifier = Modifier.padding(top = 8.dp),
        title = { Text(text = "All rooms") },
        navigationIcon = {
            IconButton(onClick = navigateBack) {
                Icon(
                    imageVector = Icons.Filled.ChevronLeft,
                    contentDescription = null,
                    modifier = Modifier.size(32.dp)
                )
            }
        },
        actions = {
            Screen.Room.actions.forEach { action ->
                IconButton(
                    onClick = {},
                    modifier = Modifier.padding(horizontal = 8.dp)
                ) {
                    Icon(
                        painter = painterResource(id = action.icon),
                        contentDescription = action.description
                    )
                }
            }
            ProfileSquircle(
                photoId = R.drawable.profile,
                onClick = navigateToProfile
            )
        },
        elevation = 0.dp,
    )
}

@Composable
fun BottomBar(
    onLeaveQuietly: () -> Unit,
    onHandRaise: (Boolean) -> Unit
) {
    BottomAppBar(
        modifier = Modifier.padding(8.dp),
        backgroundColor = MaterialTheme.colors.surface,
        elevation = 0.dp
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = onLeaveQuietly,
                modifier = Modifier.clip(shape = RoundedCornerShape(50)),
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.surface)
            ) {
                Text(
                    text = "✌\uD83C\uDFFD Leave quietly",
                    style = MaterialTheme.typography.button,
                    color = MaterialTheme.colors.error
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Rounded.Add,
                        contentDescription = null,
                        modifier = Modifier.size(32.dp)
                    )
                }

                IconButton(onClick = { /*DO NOTHING*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_hand),
                        contentDescription = null,
                        modifier = Modifier
                            .size(24.dp)
                            .pointerInput(key1 = null) {
                                detectTapGestures(
                                    onLongPress = {
                                        println("onLongPress")
                                        onHandRaise(true)
                                    },
                                    onPress = {
                                        println("onPress")
                                        onHandRaise(true)
                                        if (this.tryAwaitRelease()) {
                                            onHandRaise(false)
                                        }
                                    }
                                )
                            }
                    )
                }
            }
        }
    }
}

@Composable
fun RoomTitleBar(title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.h6,
            modifier = Modifier.fillMaxWidth(0.8f),
        )

        IconButton(onClick = {}) {
            Icon(
                imageVector = Icons.Filled.MoreHoriz,
                contentDescription = null
            )
        }
    }
}

























