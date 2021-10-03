package com.omkarcodes.instagramclone.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.omkarcodes.instagramclone.presentation.navigation.InstagramNavigation
import com.omkarcodes.instagramclone.presentation.theme.InstagramCloneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InstagramCloneTheme {
                InstagramNavigation()
            }
        }
    }
}