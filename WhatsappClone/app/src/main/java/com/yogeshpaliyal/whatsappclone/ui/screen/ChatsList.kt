package com.yogeshpaliyal.whatsappclone.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.yogeshpaliyal.whatsappclone.data.ChatModel

@Composable
fun ChatsList() {
    val listChats = ArrayList<ChatModel>()
    listChats.add(ChatModel("https://randomuser.me/api/portraits/men/39.jpg", "Sohan", "hi"))
    listChats.add(
        ChatModel(
            "https://randomuser.me/api/portraits/men/81.jpg",
            "Umesh",
            "hello, how are you yogesh, Whats going on bro"
        )
    )
    val chatLists = listChats.toMutableStateList()
    LazyColumn(modifier = Modifier.fillMaxHeight(1f)) {
        items(chatLists) { model ->
            ChatListItem(chatModel = model)
        }
    }
}


@ExperimentalCoilApi
@Composable
fun ChatListItem(chatModel: ChatModel) {
    Row(modifier = Modifier
        .fillMaxWidth(1f)
        .padding(8.dp).clickable{

        },) {
        Image(modifier = Modifier.requiredSize(40.dp).clip(CircleShape),
            painter = rememberImagePainter(data = chatModel.image,
                builder = {
                    placeholder(com.yogeshpaliyal.whatsappclone.R.drawable.dummy_user)
                    transformations(CircleCropTransformation())
                }),
            contentDescription = ""
        )

        Column(
            Modifier
                .weight(1f)
                .padding(horizontal = 8.dp)) {
            Text(text = chatModel.name,style = TextStyle(fontSize = 16.sp),color = MaterialTheme.colors.onSurface)
            Text(text = chatModel.lastMessage, maxLines = 1, overflow = TextOverflow.Ellipsis,color = MaterialTheme.colors.onSurface)
        }
        Text("12:00 AM")

    }
}

@Preview(showSystemUi = true)
@Composable()
fun ChatsListPreview() {
    ChatsList()
}