package com.vivek.clubhouseclone.presentation.ui.activity

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.vivek.clubhouseclone.data.model.User
import com.vivek.clubhouseclone.data.model.getOtherSpeakers
import com.vivek.clubhouseclone.presentation.components.ProfileSquircle

@Composable
fun ActivityScreen(
    navigateBack: () -> Unit
) {
    val followers = getOtherSpeakers().plus(getOtherSpeakers())

    Scaffold(
        topBar = {
            TopAppBar(elevation = 0.dp) {
                Box(modifier = Modifier.fillMaxSize()) {
                    IconButton(
                        onClick = navigateBack,
                        modifier = Modifier.align(Alignment.CenterStart)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.ChevronLeft,
                            contentDescription = null,
                            modifier = Modifier.size(32.dp)
                        )
                    }
                    Text(
                        text = "ACTIVITY", style = MaterialTheme.typography.subtitle1,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        }
    ) {
        LazyColumn(modifier = Modifier.padding(horizontal = 16.dp)) {
            items(followers) { follower ->
                ActivityItem(follower)
            }
        }
    }
}

@Composable
fun ActivityItem(follower: User) {
    val followedString = "${follower.name} followed you"
    val followedAnnotatedString = AnnotatedString(
        text = followedString,
        spanStyles = listOf(
            AnnotatedString.Range(
                SpanStyle(fontWeight = FontWeight.Light),
                start = follower.name.length,
                end = followedString.length
            )
        )
    )

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        ProfileSquircle(photoId = follower.photo, onClick = {})
        Text(text = followedAnnotatedString)
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "${(1..24).random()}h ago",
            style = MaterialTheme.typography.caption,
            modifier = Modifier.alpha(0.5f)
        )
    }
}



















