package com.vivek.clubhouseclone.presentation.ui.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.vivek.clubhouseclone.R
import com.vivek.clubhouseclone.data.model.getMyProfile
import com.vivek.clubhouseclone.presentation.components.ProfileSquircle
import com.vivek.clubhouseclone.presentation.navigation.Screen
import com.vivek.clubhouseclone.presentation.navigation.Screen.Home.TopAppBarAction

@Composable
fun TopBar(
    onActionClick: (action: TopAppBarAction) -> Unit,
    navigateToSearch: () -> Unit,
    navigateToProfile: () -> Unit,
) {
    TopAppBar(
        modifier = Modifier.padding(top = 8.dp),
        title = {},
        navigationIcon = {
            IconButton(onClick = navigateToSearch) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = null
                )
            }
        },
        actions = {
            Screen.Home.actions.forEach { action ->
                IconButton(
                    onClick = { onActionClick(action) },
                    modifier = Modifier.padding(horizontal = 4.dp)
                ) {
                    Icon(
                        painter = painterResource(id = action.icon),
                        contentDescription = action.description
                    )
                }
            }
            ProfileSquircle(
                photoId = getMyProfile().photo,
                onClick = navigateToProfile
            )
        },
        elevation = 0.dp,
    )
}

@Composable
fun BottomBarWithGradient() {
    val gradient = Brush.verticalGradient(
        colors = listOf(
            Color.Transparent,
            Color(0xFFF3F1E6),
            Color(0xFFF3F1E6)
        )
    )
    BottomAppBar(
        backgroundColor = Color.Transparent,
        elevation = 0.dp,
        modifier = Modifier.background(brush = gradient).fillMaxWidth().height(32.dp)
    ) {}
}