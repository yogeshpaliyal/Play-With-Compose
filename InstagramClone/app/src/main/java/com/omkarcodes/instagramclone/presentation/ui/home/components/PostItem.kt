package com.omkarcodes.instagramclone.presentation.ui.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
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
import com.omkarcodes.instagramclone.presentation.util.Constants


@Composable
fun PostItem(
    post: Post
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.height(Constants.defaultPadding /2))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = Constants.defaultPadding / 2),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = post.userImage),
                contentDescription = null,
                modifier = Modifier
                    .size(30.dp)
                    .clip(CircleShape)
            )
            Spacer(Modifier.width(Constants.defaultPadding / 2))
            Text(
                text = post.username,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.weight(1f)
            )
            Spacer(Modifier.width(Constants.defaultPadding / 2))
            Image(
                painter = painterResource(id = R.drawable.ic_more_vert),
                contentDescription = null,
                modifier = Modifier
                    .size(30.dp)
                    .padding(4.dp),
                colorFilter = ColorFilter.tint(color = Color.Black)
            )
        }
        val image = painterResource(id = post.postImage)
        val ratio = image.intrinsicSize.width / image.intrinsicSize.height
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(ratio = ratio),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(Constants.defaultPadding / 2))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row {
                ImageButton(icon = R.drawable.ic_activity)
                ImageButton(icon = R.drawable.ic_comments)
                ImageButton(icon = R.drawable.ic_send)
            }
            ImageButton(icon = R.drawable.ic_saved)
        }
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = "${post.likeCount} likes",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Constants.defaultPadding / 3),
        )
        Text(
            text = buildAnnotatedString {
                pushStyle(SpanStyle(fontWeight = FontWeight.Bold))
                append(post.username)
                append(" ")
                pop()
                append(post.caption)
            },
            fontSize = 14.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Constants.defaultPadding / 3, vertical = 2.dp),
        )
        Text(
            text = "View all ${post.commentCount} comments",
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            color = colorGrey2,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Constants.defaultPadding / 3)
        )
    }
}

@Composable
fun ImageButton(
    icon: Int,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = icon),
        contentDescription = null,
        modifier = modifier
            .size(36.dp)
            .padding(6.dp),
        colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onBackground)
    )
}
