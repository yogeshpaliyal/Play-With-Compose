package com.omkarcodes.instagramclone.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import com.omkarcodes.instagramclone.presentation.navigation.InstagramNavigation
import com.omkarcodes.instagramclone.presentation.theme.InstagramCloneTheme

class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InstagramCloneTheme {
                InstagramNavigation()
            }
        }
    }
}