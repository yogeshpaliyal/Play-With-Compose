package com.omkarcodes.instagramclone.presentation.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.omkarcodes.instagramclone.R
import com.omkarcodes.instagramclone.data.model.Story
import com.omkarcodes.instagramclone.presentation.theme.colorGrey2
import com.omkarcodes.instagramclone.presentation.ui.home.components.StorySection
import com.omkarcodes.instagramclone.presentation.ui.home.components.TopBar
import com.omkarcodes.instagramclone.presentation.util.Constants
import com.omkarcodes.instagramclone.presentation.util.Constants.storiesList

@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            TopBar()
        }
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                StorySection(
                    stories = storiesList
                )
            }
        }
    }
}
