package com.vivek.clubhouseclone.presentation.ui.home.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.vivek.clubhouseclone.data.model.getUpcomingEvents

@Composable
fun UpcomingEvents() {
    val events = getUpcomingEvents()

    Column(modifier = Modifier.padding(8.dp)) {
        events.forEach { event ->
            Row {
                Text(text = event.time, color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f))
                Spacer(modifier = Modifier.size(8.dp))
                Column {
                    if (event.title.isNotEmpty()) {
                        Text(
                            text = event.title,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.body1
                        )
                    }
                    Text(
                        text = event.subtitle,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Medium)
                    )
                }
            }
        }
    }
}