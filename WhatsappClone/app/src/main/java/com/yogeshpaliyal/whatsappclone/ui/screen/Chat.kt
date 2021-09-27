package com.yogeshpaliyal.whatsappclone.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yogeshpaliyal.whatsappclone.R
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
        Surface {
            Column {
                LazyColumn(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(1f), reverseLayout = true
                ) {
                    items(messages) { message ->
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(1f)
                                .padding(8.dp)
                        ) {


                            val isSent = message.senderId == 1

                            val alignment =
                                if (isSent) Alignment.CenterEnd else Alignment.CenterStart
                            Box(
                                modifier = Modifier
                                    .clip(
                                        MaterialTheme.shapes.small.copy(
                                            topStart = CornerSize(if (isSent) 8.dp else 0.dp),
                                            topEnd = CornerSize(if(isSent) 0.dp else 8.dp),
                                            bottomStart = CornerSize(8.dp),
                                            bottomEnd = CornerSize(8.dp)
                                        )
                                    )
                                    .align(alignment = alignment)
                                    .background(MaterialTheme.colors.primary)
                            ) {
                                Box(
                                    modifier = Modifier.padding(
                                        horizontal = 8.dp,
                                        vertical = 4.dp
                                    )
                                ) {
                                    Text(
                                        message.message,
                                        color = MaterialTheme.colors.onPrimary
                                    )
                                }
                            }

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
                            .background(if (isSystemInDarkTheme()) MaterialTheme.colors.primary else MaterialTheme.colors.surface)
                    ) {

                        TextField(
                            value = "",
                            leadingIcon = {
                                IconButton(onClick = { }) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_baseline_emoji_emotions_24),
                                        "Select Emoji"
                                    )
                                }
                            },
                            colors = TextFieldDefaults.textFieldColors(
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent
                            ),
                            shape = MaterialTheme.shapes.small.copy(CornerSize(50)),
                            modifier = Modifier
                                .weight(1f)
                                .border(BorderStroke(0.dp, Color.Transparent)),
                            onValueChange = {

                            },
                            trailingIcon = {
                                IconButton(onClick = { }) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_baseline_attach_file_24),
                                        "Select Emoji"
                                    )
                                }
                            },
                            label = {
                                Text(text = "Enter Message")
                            })

                        Spacer(modifier = Modifier.width(8.dp))

                        Box(
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .height(IntrinsicSize.Max)
                        ) {
                            IconButton(modifier = Modifier
                                .clip(
                                    MaterialTheme.shapes.small.copy(
                                        CornerSize(50)
                                    )
                                )
                                .fillMaxHeight(1f)
                                .padding(start = 0.dp)
                                .background(MaterialTheme.colors.primary),
                                onClick = { /*TODO*/ }) {
                                Icon(Icons.Rounded.Send, "", tint = Color.White)
                            }
                        }
                    }

                }
            }
        }
    }
}

@Preview(showSystemUi = true, name = "Dark Chat")
@Composable
fun PreviewChat() {
    WhatsappCloneTheme(darkTheme = true) {
        Surface {
            Chat(ChatModel("", "Sohan", "Hello"))
        }
    }
}

@Preview(showSystemUi = true, name = "Light Chat")
@Composable
fun PreviewChatLight() {
    WhatsappCloneTheme(darkTheme = false) {
        Surface {
            Chat(ChatModel("", "Sohan", "Hello"))
        }
    }
}