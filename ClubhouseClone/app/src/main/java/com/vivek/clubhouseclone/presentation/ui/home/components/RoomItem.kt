package com.vivek.clubhouseclone.presentation.ui.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.vivek.clubhouseclone.R
import com.vivek.clubhouseclone.data.model.Room
import com.vivek.clubhouseclone.presentation.components.ProfileSquircle

@Composable
fun RoomItem(room: Room, onRoomClick: (Int) -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth().clickable { onRoomClick(room.id) },
        shape = RoundedCornerShape(20.dp),
        elevation = 0.dp
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            if (room.subtitle.isNotEmpty()) {
                BasicText(text = room.subtitle)
            }
            BasicText(text = room.title, style = MaterialTheme.typography.h6)

            Spacer(modifier = Modifier.size(8.dp))

            Row {
                Box {
                    val size = room.users.size - 1
                    val randomProfileBelow = (0..size / 2).random()
                    val randomProfileAbove = (size / 2 + 1..size).random()
                    ProfileSquircle(
                        photoId = room.users[randomProfileBelow].photo,
                        size = 50.dp,
                        cornerRadius = 20.dp,
                        padding = 0.dp,
                        onClick = {}
                    )
                    ProfileSquircle(
                        photoId = room.users[randomProfileAbove].photo,
                        size = 50.dp,
                        cornerRadius = 20.dp,
                        padding = 0.dp,
                        onClick = {},
                        xDp = 24.dp, yDp = 24.dp
                    )
                }

                Spacer(modifier = Modifier.size(40.dp))

                // NOTE: -10.dp, due to some font issue
                Column(verticalArrangement = Arrangement.spacedBy((-10).dp)) {
                    room.users.forEach { user ->
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(text = user.name, style = MaterialTheme.typography.subtitle1)
                            Spacer(modifier = Modifier.size(8.dp))
                            Icon(painter = painterResource(id = R.drawable.ic_chat_outline), null)
                        }
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        BasicText(
                            text = room.users.size.toString() + "k",
                            style = MaterialTheme.typography.body1
                        )
                        Spacer(modifier = Modifier.size(4.dp))
                        Icon(painter = painterResource(id = R.drawable.ic_person_filled), null)
                        BasicText(
                            text = " / ${room.users.size / 2}",
                            style = MaterialTheme.typography.body1
                        )
                        Spacer(modifier = Modifier.size(4.dp))
                        Icon(painter = painterResource(id = R.drawable.ic_chat_filled), null)
                    }
                }
            }
        }
    }
}