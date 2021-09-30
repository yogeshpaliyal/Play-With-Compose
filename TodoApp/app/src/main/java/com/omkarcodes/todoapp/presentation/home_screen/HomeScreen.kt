package com.omkarcodes.todoapp.presentation.home_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.omkarcodes.todoapp.R
import com.omkarcodes.todoapp.domain.model.Todo

@ExperimentalMaterialApi
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    var text by remember { mutableStateOf("") }
    Scaffold(
        topBar = { TopBar( title = "Todo" ) },
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            LazyColumn(
                modifier = Modifier.weight(1f)
            ){
                items(viewModel.state.value.size){ pos ->
                    val todo = viewModel.state.value[pos]
                    TodoItem(
                        todo = todo,
                        onChecked = {
                            viewModel.insertOrUpdateTodo(todo.copy(isChecked = it))
                        },
                        onDelete = {
                            viewModel.deleteTodo(todo)
                        }
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ){
                TextField(
                    value = text,
                    onValueChange = {
                        text = it
                    },
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp),
                )
                Spacer(modifier = Modifier.width(8.dp))
                FloatingActionButton(
                    onClick = {
                        if (text.isNotEmpty()){
                            viewModel.insertOrUpdateTodo(Todo(text = text))
                            text = ""
                        }
                    },
                    modifier = Modifier.size(48.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_add),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(MaterialTheme.colors.onBackground),
                        modifier = Modifier.padding(4.dp)
                    )
                }
            }
        }

    }
}

@Composable
fun TopBar(
    title: String,
    titleFontSize: TextUnit = 20.sp,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(elevation = 2.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            fontSize = titleFontSize,
            color = MaterialTheme.colors.onBackground,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .weight(1f)
                .padding(vertical = 12.dp, horizontal = 20.dp),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
fun TodoItem(
    todo: Todo,
    onChecked: (b: Boolean) -> Unit,
    onDelete: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = todo.isChecked,
            onCheckedChange = onChecked
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = todo.text,
            modifier = Modifier.weight(1f),
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            color = if (todo.isChecked) MaterialTheme.colors.onSecondary else MaterialTheme.colors.onBackground,
            textDecoration = if (todo.isChecked) TextDecoration.LineThrough else null,
        )
        Spacer(modifier = Modifier.width(16.dp))
        Image(
            painter = painterResource(id = R.drawable.ic_baseline_delete_24),
            contentDescription = null,
            modifier = Modifier
                .size(24.dp)
                .clickable { onDelete() },
            colorFilter = ColorFilter.tint(Color.Red)
        )
    }
}
