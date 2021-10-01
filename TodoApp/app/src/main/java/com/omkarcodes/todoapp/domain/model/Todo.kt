package com.omkarcodes.todoapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todos")
data class Todo(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val text: String,
    val isChecked: Boolean = false,
)
