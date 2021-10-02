package com.vivek.clubhouseclone.data.model

import androidx.compose.runtime.mutableStateOf

data class Room(
    val id: Int,
    val title: String = "",
    val subtitle: String = "",
    val users: MutableList<User> = mutableListOf()
)

val rooms = mutableStateOf<List<Room>>(listOf())
val enteredRoom = mutableStateOf<Room>(Room(id = -1))

fun getRooms() {
    rooms.value = listOf(
        Room(
            id = 1,
            title = "UI Design and Android Developers",
            subtitle = "Designers \uD83C\uDFA8 & Developers \uD83D\uDC68\u200D\uD83D\uDCBB",
            users = getUsers()
        ),
        Room(
            id = 2,
            title = "How to Brand Yourself & the Business of Clubhouse",
            subtitle = " \uD83E\uDD13 TALK NERDY TO ME ☠️ \uD83D\uDC7D \uD83D\uDC7E \uD83E\uDD16 \uD83C\uDF83 ",
            users = getUsers()
        ),
        Room(
            id = 3,
            title = "What's Clubhouse \uD83D\uDC4B",
            users = getUsers()
        ),
        Room(
            id = 4,
            title = "Jetpack Compose talk \uD83D\uDDE3",
            users = getUsers()
        )
    )
}

fun getEnteredRoom(roomId: Int) {
    for (room in rooms.value) {
        if (roomId == room.id) {
            enteredRoom.value = room
        }
    }
    // entering room after fetching room details, so me user get entered in current room
    enterRoom()
}

fun enterRoom() {
    val roomUsers = enteredRoom.value.users
    if (roomUsers.contains(getMyProfile())) {   // don't want to add multiple instance of me user
        leaveRoom()
    }
    enteredRoom.value.users.add(getMyProfile())
}

fun leaveRoom() {
    enteredRoom.value.users.remove(getMyProfile())
}
