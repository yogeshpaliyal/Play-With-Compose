package com.yogeshpaliyal.composecookbook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.yogeshpaliyal.composecookbook.data.UserModel
import com.yogeshpaliyal.composecookbook.ui.theme.ComposeCookbookTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCookbookTheme(darkTheme = true) {
                // A surface container using the 'background' color from the theme
                Surface() {
                    Dashboard()
                }
            }
        }
    }
}

@Composable
fun Dashboard(mViewModel: MainActivityViewModel = viewModel()) {

    val users by mViewModel.usersList.observeAsState(listOf<UserModel>())

    val query by mViewModel.searchQuery.observeAsState("")


    Scaffold() {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        ) {

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(13.dp),
                value = query,
                placeholder = { Text(text = "Search Movie") },
                onValueChange = {
                    mViewModel.updateSearchQuery(it)
                })

            LazyColumn(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(), content = {
                items(users) { userModel ->
                    Card(modifier = Modifier
                        .fillParentMaxWidth().padding(10.dp),elevation = 4.dp, shape = MaterialTheme.shapes.small.copy(topStart = CornerSize(12f))) {
                        Column(modifier = Modifier.padding(20.dp)) {
                            Text(text = userModel.name,color = Color.Black)
                        }
                    }
                }
            })
        }

    }
}

@Preview(showBackground = true,showSystemUi = true)
@Composable
fun DefaultPreview() {
    ComposeCookbookTheme {
        Dashboard()
    }
}
