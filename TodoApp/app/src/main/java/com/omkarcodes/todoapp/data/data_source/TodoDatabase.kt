package com.omkarcodes.todoapp.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.omkarcodes.todoapp.domain.model.Todo

@Database(entities = [Todo::class],version = 1)
abstract class TodoDatabase : RoomDatabase() {

    abstract val todoDao: TodoDao

    companion object {
        const val DATABASE_NAME = "todo_db"
    }

}