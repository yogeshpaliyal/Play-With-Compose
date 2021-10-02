package com.vivek.clubhouseclone.presentation.ui.room.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.vivek.clubhouseclone.data.model.User
import com.vivek.clubhouseclone.presentation.components.ProfileSquircle
import com.vivek.clubhouseclone.presentation.util.getTextWithEllipses
import com.vivek.clubhouseclone.presentation.util.toGridList

@Composable
fun SpeakersList(
    users: List<User>,
    toggleMic: Boolean
) {
    val usersGridList = users.toGridList(cols = 3)

    Grid(
        itemList = usersGridList
    ) { user ->
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            ProfileSquircle(
                photoId = user?.photo,
                onClick = {},
                size = 72.dp,
                cornerRadius = 32.dp,
                isInRoom = true,
                isMute = (user?.id ?: 0) % 2 != 0,
                toggleMic = toggleMic
            )
            Text(
                text = getTextWithEllipses(user?.name ?: "", 10),
                style = MaterialTheme.typography.body1
            )
        }
    }
}

@Composable
fun OtherParticipantsList(
    users: List<User>
) {
    val usersGridList = users.toGridList(cols = 4)

    Grid(
        itemList = usersGridList
    ) { user ->
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            ProfileSquircle(
                photoId = user?.photo,
                onClick = {},
                size = 60.dp,
                cornerRadius = 24.dp
            )
            Text(
                text = getTextWithEllipses(user?.name ?: "", 7),
                style = MaterialTheme.typography.body1
            )
        }
    }
}

@Composable
fun <T> Grid(
    itemList: List<List<T?>>,
    modifier: Modifier = Modifier,
    itemContent: @Composable (item: T?) -> Unit
) {
    Column(
        modifier = modifier.padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        for (rowList in itemList) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                for (item in rowList) {
                    itemContent(item)
                }
            }
        }
    }
}