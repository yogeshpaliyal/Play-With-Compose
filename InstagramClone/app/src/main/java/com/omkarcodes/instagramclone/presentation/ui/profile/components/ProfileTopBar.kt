package com.omkarcodes.instagramclone.presentation.ui.profile.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.omkarcodes.instagramclone.R
import com.omkarcodes.instagramclone.presentation.util.Constants


@Composable
fun ProfileTopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.ic_lock),
            contentDescription = null,
            modifier = Modifier
                .size(24.dp)
                .padding(all = 2.dp),
            colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onBackground)
        )
        Spacer(modifier = Modifier.width(2.dp))
        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "omkar_bhostekar",
                color = MaterialTheme.colors.onBackground,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Image(
                painter = painterResource(R.drawable.ic_arrow_down),
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
                    .padding(all = 3.dp),
                colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onBackground)
            )
        }
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
            painter = painterResource(R.drawable.ic_menu),
            contentDescription = null,
            modifier = Modifier
                .padding(2.dp)
                .fillMaxHeight()
                .aspectRatio(1f),
            colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onBackground)
        )
    }
}