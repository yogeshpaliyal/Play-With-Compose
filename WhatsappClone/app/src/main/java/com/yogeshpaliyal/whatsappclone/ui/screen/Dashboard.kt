package com.yogeshpaliyal.whatsappclone.ui.screen

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Create
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yogeshpaliyal.whatsappclone.ui.theme.WhatsappCloneTheme


@Composable
fun Dashboard() {

        Scaffold(topBar = {
            TopAppBar(backgroundColor = MaterialTheme.colors.primaryVariant) {
                Column {
                    TopAppBar(elevation = 0.dp,
                        backgroundColor = Color.Companion.Transparent,
                        title = {
                            Text(text = "Whatsapp Clone",color = MaterialTheme.colors.onPrimary,)
                        },
                        actions = {
                            IconButton(onClick = { }) {
                                Icon(tint = MaterialTheme.colors.onPrimary,imageVector = Icons.Rounded.Search, contentDescription = "Search")
                            }
                            IconButton(onClick = {  }) {
                                Icon(Icons.Rounded.MoreVert, "Option Menu")
                            }
                        })
                  /*  ScrollableTabRow(selectedTabIndex = 0) {
                        Tab(selected = false, onClick = { *//*TODO*//* }) {
                            Icon(painter = painterResource(id = com.yogeshpaliyal.whatsappclone.R.drawable.ic_baseline_camera_alt_24), "")
                        }
                    }*/
                }
            }
        }, floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Rounded.Create,"New Chat")
            }
        }) {
            Surface() {
                ChatsList()
            }
        }

}

@Preview(showSystemUi = true, name = "Dashboard")
@Composable
fun DashboardPreview(){
    WhatsappCloneTheme(darkTheme = false) {
        Dashboard()
    }
}