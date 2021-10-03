package com.omkarcodes.instagramclone.presentation.util

import androidx.compose.ui.unit.dp
import com.omkarcodes.instagramclone.R
import com.omkarcodes.instagramclone.data.model.Post
import com.omkarcodes.instagramclone.data.model.Story

object Constants {

    val defaultPadding = 16.dp

    val storiesList = listOf(
        Story(R.drawable.avatar_2,"prathmesh226",false),
        Story(R.drawable.avatar_1,"saurabh",false),
        Story(R.drawable.avatar_5,"mahesh",false),
        Story(R.drawable.avatar_4,"akash",false),
        Story(R.drawable.avatar_2,"nehal",false),
        Story(R.drawable.avatar_3,"pushkaraj",true),
        Story(R.drawable.avatar_1,"tejas",true),
        Story(R.drawable.avatar_2,"sanket",true),
    )

    const val DEFAULT_CAPTION = "Lorem Ipsum is simply dummy text of the printing and typesetting industry."

    val postList = listOf(
        Post("omkar_bhostekar",R.drawable.profile,R.drawable.post_4, DEFAULT_CAPTION,475,21),
        Post("prathmesh226",R.drawable.avatar_2,R.drawable.post_5, DEFAULT_CAPTION,127,11),
        Post("saurabh",R.drawable.avatar_1,R.drawable.post_1, DEFAULT_CAPTION,1256,51),
        Post("akash",R.drawable.avatar_4,R.drawable.post_3, DEFAULT_CAPTION,85,4),
    )
}