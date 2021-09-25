package com.yogeshpaliyal.whatsappclone.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yogeshpaliyal.whatsappclone.data.ChatModel
import com.yogeshpaliyal.whatsappclone.data.MessageModel
import com.yogeshpaliyal.whatsappclone.ui.theme.WhatsappCloneTheme


@Composable
fun Chat(chatModel: ChatModel) {

    val messages = ArrayList<MessageModel>()

    messages.add(MessageModel(chatModel.lastMessage, 1, 2))
    messages.add(MessageModel(chatModel.lastMessage, 2, 1))

    Scaffold(topBar = {
        TopAppBar(title = {
            Text(text = chatModel.name)
        }, backgroundColor = MaterialTheme.colors.primary)
    }) {
        Column {
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(1f), reverseLayout = true
            ) {
                items(messages) { message ->
                    Box(modifier = Modifier
                        .fillMaxWidth(1f)
                        .padding(8.dp)) {

                        val alignment =
                            if (message.senderId == 1) Alignment.CenterEnd else Alignment.CenterStart
                        Text(
                            message.message,
                            modifier = Modifier.align(alignment = alignment)
                        )
                    }
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(start = 8.dp, end = 8.dp, bottom = 8.dp)
            ) {

                Row(
                    Modifier
                        .fillMaxWidth(1f)
                        .clip(RoundedCornerShape(50)).background(MaterialTheme.colors.surface)) {

                    TextField(
                        value = "",
                        modifier = Modifier
                            .weight(1f),
                        onValueChange = {

                        })

                    IconButton(onClick = { /*TODO*/ },) {
                        Icon(Icons.Rounded.Send,"", tint = MaterialTheme.colors.onSurface)
                    }

                }

            }
        }
    }
}

@Preview
@Composable
fun PreviewChat() {
    WhatsappCloneTheme {
        Surface {
            Chat(ChatModel("", "Sohan", "Hello"))
        }
    }
}