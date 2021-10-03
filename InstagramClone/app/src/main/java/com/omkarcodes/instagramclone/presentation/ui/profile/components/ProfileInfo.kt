package com.omkarcodes.instagramclone.presentation.ui.profile.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.omkarcodes.instagramclone.R
import com.omkarcodes.instagramclone.presentation.theme.colorGrey2
import com.omkarcodes.instagramclone.presentation.util.Constants


@Composable
fun ProfileInfo() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Constants.defaultPadding, vertical = Constants.defaultPadding / 2),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = null,
                modifier = Modifier
                    .weight(2.5f)
                    .aspectRatio(1f)
                    .border(
                        width = 2.dp,
                        color = colorGrey2,
                        shape = CircleShape
                    )
                    .padding(5.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(Constants.defaultPadding))
            Row(
                modifier = Modifier.weight(6f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                ProfileStat(text = "Posts", count = 9, modifier = Modifier.weight(1f))
                ProfileStat(text = "Followers", count = 328, modifier = Modifier.weight(1f))
                ProfileStat(text = "Following", count = 169, modifier = Modifier.weight(1f))
            }
        }
        Text(
            text = "Omkar Bhostekar",
            fontSize = 14.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Constants.defaultPadding),
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colors.onBackground
        )
        Text(
            text = "${Constants.DEFAULT_CAPTION} ${Constants.DEFAULT_CAPTION}",
            fontSize = 13.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Constants.defaultPadding),
            maxLines = 3,
            overflow = TextOverflow.Ellipsis,
            color = MaterialTheme.colors.onBackground
        )
    }
}

