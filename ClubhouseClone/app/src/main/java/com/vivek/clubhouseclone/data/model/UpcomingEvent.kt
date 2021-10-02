package com.vivek.clubhouseclone.data.model

data class UpcomingEvent(
    val time: String = "",
    val title: String = "",
    val subtitle: String = "",
    val details: String = "",
    val participants: List<User> = listOf()
)

fun getUpcomingEvents(): List<UpcomingEvent> {
    return listOf(
        UpcomingEvent(
            time = "5:00 PM",
            title = "FOOTBALL CLUB",
            subtitle = "Football ❤️ PSG vs Barca at 1 AM. Wanna support Messi or Mbappe ?",
            details = "",
            participants = listOf()
        ),
        UpcomingEvent(
            time = "6:30 PM",
            title = "",
            subtitle = "I am triggered \uD83D\uDE21 Don't know why",
            details = "",
            participants = listOf()
        ),

        UpcomingEvent(
            time = "7:00 PM",
            title = "DR. DISRESPECT",
            subtitle = "Violence.⚔️  Speed.\uD83C\uDFCE  Momentum.\uD83C\uDFAE ️",
            details = "",
            participants = listOf()
        )
    )
}
