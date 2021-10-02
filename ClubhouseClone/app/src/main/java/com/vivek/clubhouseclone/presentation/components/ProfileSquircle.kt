package com.vivek.clubhouseclone.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MicOff
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ProfileSquircle(
    photoId: Int?,
    size: Dp = 36.dp,
    cornerRadius: Dp = 15.dp,
    xDp: Dp = 0.dp,
    yDp: Dp = 0.dp,
    padding: Dp = 8.dp,
    onClick: () -> Unit,
    isInRoom: Boolean = false,
    isMute: Boolean = false,
    toggleMic: Boolean = false
) {
    val modifier = Modifier
        .absoluteOffset(x = xDp, y = yDp)
        .padding(padding)
        .requiredSize(size)
        .clip(shape = RoundedCornerShape(size = cornerRadius))

    if (isInRoom && isMute) {           // user in room and mute
        Box {
            ProfileImage(photoId = photoId, onClick = onClick, modifier = modifier)
            Box(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .background(MaterialTheme.colors.surface, CircleShape)
                    .padding(4.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.MicOff,
                    contentDescription = null
                )
            }
        }
    } else if (isInRoom && !isMute) {     // user in room and NOT mute
        if (toggleMic) {                  // user mic ON, showing border
            // can't change size, if modifier.size(dp) is already been set
            ProfileImage(
                photoId = photoId,
                onClick = onClick,
                modifier = Modifier
                    .absoluteOffset(x = xDp, y = yDp)
                    .requiredSize(size + 16.dp)
                    .border(
                        4.dp,
                        MaterialTheme.colors.primaryVariant,
                        shape = RoundedCornerShape(size = cornerRadius + 4.dp)
                    )
                    .padding(8.dp)
                    .clip(shape = RoundedCornerShape(size = cornerRadius))
            )
        } else {                          // user mic OFF, NOT showing border
            ProfileImage(photoId = photoId, onClick = onClick, modifier = modifier)
        }
    } else {                              // use NOT in room
        ProfileImage(photoId = photoId, onClick = onClick, modifier = modifier)
    }
}

@Composable
private fun ProfileImage(
    photoId: Int?,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    if (photoId != null) {
        Image(
            painter = painterResource(id = photoId), contentDescription = "profile",
            contentScale = ContentScale.Crop,
            modifier = modifier.clickable { onClick() }
        )
    } else {
        Box(
            modifier = modifier.background(color = MaterialTheme.colors.surface)
        )
    }
}















