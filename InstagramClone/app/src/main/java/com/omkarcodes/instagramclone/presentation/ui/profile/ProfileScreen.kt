package com.omkarcodes.instagramclone.presentation.ui.profile

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.omkarcodes.instagramclone.R
import com.omkarcodes.instagramclone.data.model.ImageWithText
import com.omkarcodes.instagramclone.presentation.ui.profile.components.*
import com.omkarcodes.instagramclone.presentation.util.Constants.defaultPadding

@ExperimentalFoundationApi
@Composable
fun ProfileScreen() {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    Scaffold(
        topBar = { ProfileTopBar() },
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            ProfileInfo()
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(defaultPadding)
            ) {
                ActionButton(text = "Edit Profile",modifier = Modifier.weight(9f))
                Spacer(modifier = Modifier.width(defaultPadding/2))
                ActionButton(icon = R.drawable.ic_arrow_down,modifier = Modifier.weight(1f))
            }
            HighlightSection(
                highlights = listOf(
                    ImageWithText(
                        image = painterResource(id = R.drawable.highlight_1),
                        text = "Facebook"
                    ),
                    ImageWithText(
                        image = painterResource(id = R.drawable.highlight_3),
                        text = "Telegram"
                    ),
                    ImageWithText(
                        image = painterResource(id = R.drawable.highlight_4),
                        text = "WhatsApp"
                    ),
                    ImageWithText(
                        image = painterResource(id = R.drawable.highlight_2),
                        text = "Instagram"
                    ),
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            PostTabView(
                imageWithTexts = listOf(
                    ImageWithText(
                        image = painterResource(id = R.drawable.ic_grid),
                        text = "Posts"
                    ),
                    ImageWithText(
                        image = painterResource(id = R.drawable.ic_reels_tab),
                        text = "Reels"
                    ),
                    ImageWithText(
                        image = painterResource(id = R.drawable.ic_igtv),
                        text = "IGTV"
                    ),
                    ImageWithText(
                        image = painterResource(id = R.drawable.profile_tab),
                        text = "Profile"
                    ),
                ),
            ){
                selectedTabIndex = it
            }
            when(selectedTabIndex){
                0 -> {
                    PostSection(
                        posts = listOf(
                            painterResource(id = R.drawable.post_4),
                            painterResource(id = R.drawable.post_5),
                            painterResource(id = R.drawable.post_1),
                            painterResource(id = R.drawable.post_2),
                            painterResource(id = R.drawable.post_3),
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}
