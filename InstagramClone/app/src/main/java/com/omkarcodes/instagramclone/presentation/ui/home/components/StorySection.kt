package com.omkarcodes.instagramclone.presentation.ui.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.omkarcodes.instagramclone.R
import com.omkarcodes.instagramclone.data.model.Story
import com.omkarcodes.instagramclone.presentation.theme.colorGrey2
import com.omkarcodes.instagramclone.presentation.util.Constants


@Composable
fun StorySection(
    stories: List<Story>
) {
    LazyRow {
        item {
            Spacer(modifier = Modifier.width(Constants.defaultPadding))
            YourStory()
            Spacer(modifier = Modifier.width(Constants.defaultPadding))
        }
        items(stories.size) {
            Story(story = stories[it])
            Spacer(modifier = Modifier.width(Constants.defaultPadding))
        }
    }
}

@Composable
fun YourStory() {
    Column(
        modifier = Modifier
            .width(65.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .border(
                    width = 2.dp,
                    color = colorGrey2,
                    shape = CircleShape
                )
                .padding(4.dp)
                .clip(CircleShape)
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )
        }
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = "Your Story",
            modifier = Modifier.fillMaxWidth(),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            color = MaterialTheme.colors.onBackground,
            fontSize = 11.sp,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun Story(
    story: Story
) {
    val borderColor = if (story.isViewed) Brush.linearGradient(
        colors = listOf(colorGrey2, colorGrey2)
    ) else Brush.linearGradient(
        colors = listOf(
            Color(0xFFF58529),
            Color(0xFFDD2A7B),
            Color(0xFFFEDA77)
        )
    )
    Column(
        modifier = Modifier
            .width(65.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .border(
                    width = 2.dp,
                    brush = borderColor,
                    shape = CircleShape
                )
                .padding(4.dp)
                .clip(CircleShape)
        ) {
            Image(
                painter = painterResource(id = story.image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )
        }
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = story.name,
            modifier = Modifier.fillMaxWidth(),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            color = MaterialTheme.colors.onBackground,
            fontSize = 11.sp,
            textAlign = TextAlign.Center,
        )
    }
}