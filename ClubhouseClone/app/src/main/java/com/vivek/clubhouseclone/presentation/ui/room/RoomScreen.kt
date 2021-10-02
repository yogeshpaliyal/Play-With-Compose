package com.vivek.clubhouseclone.presentation.ui.room

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.vivek.clubhouseclone.data.model.enteredRoom
import com.vivek.clubhouseclone.data.model.getEnteredRoom
import com.vivek.clubhouseclone.data.model.getOtherSpeakers
import com.vivek.clubhouseclone.presentation.ui.room.components.BottomBar
import com.vivek.clubhouseclone.presentation.ui.room.components.OtherParticipantsList
import com.vivek.clubhouseclone.presentation.ui.room.components.RoomTitleBar
import com.vivek.clubhouseclone.presentation.ui.room.components.SpeakersList
import com.vivek.clubhouseclone.presentation.ui.room.components.TopBar

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun RoomScreen(
    enteredRoomId: Int,
    navigateBack: () -> Unit,
    navigateToProfile: () -> Unit,
    onLeaveQuietly: (Int) -> Unit
) {
    getEnteredRoom(roomId = enteredRoomId)

    val room = enteredRoom.value

    val isMute = remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopBar(
                navigateBack = navigateBack,
                navigateToProfile = navigateToProfile
            )
        },
        bottomBar = {
            BottomBar(
                onLeaveQuietly = { onLeaveQuietly(room.id) },
                onHandRaise = {
                    println("Before isMute: ${isMute.value}")
                    isMute.value = it
                    println("After isMute: ${isMute.value}")
                }
            )
        }
    ) { scaffoldPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 8.dp)
                .clip(RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
                .background(color = MaterialTheme.colors.surface)
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        top = 8.dp,
                        start = 8.dp,
                        end = 8.dp,
                        bottom = scaffoldPadding.calculateBottomPadding()
                    )
            ) {
                item {
                    RoomTitleBar(title = room.title)
                }

                item {
                    SpeakersList(room.users, toggleMic = isMute.value)
                }

                item {
                    Text(
                        text = "Others in the room",
                        style = MaterialTheme.typography.subtitle1,
                        color = MaterialTheme.colors.primaryVariant,
                        modifier = Modifier.padding(horizontal = 24.dp, vertical = 16.dp)
                    )
                    OtherParticipantsList(users = getOtherSpeakers())
                }
            }
        }
    }
}












