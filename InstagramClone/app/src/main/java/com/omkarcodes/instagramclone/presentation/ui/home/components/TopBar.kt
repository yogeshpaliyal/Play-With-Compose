package com.omkarcodes.instagramclone.presentation.ui.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.omkarcodes.instagramclone.R
import com.omkarcodes.instagramclone.presentation.util.Constants


@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(12.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(id = R.drawable.instagram_text_logo),
            contentDescription = null,
            modifier = Modifier.fillMaxHeight(),
            colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onBackground)
        )
        Row {
            Image(
                painter = painterResource(R.drawable.add_post),
                contentDescription = null,
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxHeight()
                    .aspectRatio(1f),
                colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onBackground)
            )
            Spacer(modifier = Modifier.width(Constants.defaultPadding / 2))
            Image(
                painter = painterResource(R.drawable.messenger),
                contentDescription = null,
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxHeight()
                    .aspectRatio(1f),
                colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onBackground)
            )
        }
    }
}