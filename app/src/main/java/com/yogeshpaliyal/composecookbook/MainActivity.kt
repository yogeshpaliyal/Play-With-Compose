package com.yogeshpaliyal.composecookbook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.VectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.yogeshpaliyal.composecookbook.data.UserModel
import com.yogeshpaliyal.composecookbook.ui.theme.ComposeCookbookTheme
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha


class MainActivity : ComponentActivity() {


    private val mViewModel by viewModels<MainActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCookbookTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Dashboard(mViewModel)
                }
            }
        }
    }
}

@Composable
fun Dashboard(mViewModel : MainActivityViewModel) {

    val users by mViewModel.usersList.observeAsState(listOf<UserModel>())


    Scaffold(topBar = {
        TopAppBar(navigationIcon = {
                                   Icon(Icons.TwoTone.Delete, contentDescription = "")
        },title = {
            Text(text = "Title")
        })
    }) {
        LazyColumn(modifier = Modifier.fillMaxHeight().fillMaxWidth(),content = {
            items(users){ index ->
                Text(text = index.name)
            }
        })
    }
}

/*
@Preview(showBackground = true,showSystemUi = true)
@Composable
fun DefaultPreview() {
    ComposeCookbookTheme {
        Dashboard()
    }
}*/
