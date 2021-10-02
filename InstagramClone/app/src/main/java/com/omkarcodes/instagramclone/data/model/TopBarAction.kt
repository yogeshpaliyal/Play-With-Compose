package com.omkarcodes.instagramclone.data.model

data class TopBarAction(
    val icon: Int,
    val desc: String? = null,
    val onClick: () -> Unit
)