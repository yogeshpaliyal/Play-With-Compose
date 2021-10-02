package com.omkarcodes.instagramclone.presentation.ui.home

import android.widget.ImageButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.omkarcodes.instagramclone.R
import com.omkarcodes.instagramclone.data.model.Post
import com.omkarcodes.instagramclone.presentation.theme.colorGrey2
import com.omkarcodes.instagramclone.presentation.ui.home.components.PostItem
import com.omkarcodes.instagramclone.presentation.ui.home.components.StorySection
import com.omkarcodes.instagramclone.presentation.ui.home.components.TopBar
import com.omkarcodes.instagramclone.presentation.util.Constants.defaultPadding
import com.omkarcodes.instagramclone.presentation.util.Constants.postList
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
                Spacer(modifier = Modifier.height(defaultPadding / 2))
                StorySection(
                    stories = storiesList
                )
                Spacer(modifier = Modifier.height(defaultPadding / 2))
                Divider(
                    thickness = 0.4.dp,
                    color = colorGrey2
                )
            }
            items(postList.size) {
                PostItem(postList[it])
            }
        }
    }
}
