package com.vivek.clubhouseclone.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.vivek.clubhouseclone.R
import com.vivek.clubhouseclone.presentation.navigation.ClubhouseCloneNavigation
import com.vivek.clubhouseclone.presentation.theme.ClubhouseCloneTheme

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_ClubhouseClone)
        super.onCreate(savedInstanceState)

        setContent {
            ClubhouseCloneMain()
        }
    }

    @Composable
    private fun ClubhouseCloneMain() {
        ClubhouseCloneTheme {
            Surface(color = MaterialTheme.colors.background) {
                ClubhouseCloneNavigation()
            }
        }
    }
}