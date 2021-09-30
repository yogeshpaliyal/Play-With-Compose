package com.omkarcodes.todoapp.domain.repository

import com.omkarcodes.todoapp.domain.model.Todo
import kotlinx.coroutines.flow.Flow

interface TodoRepository {

    fun getTodos() : Flow<List<Todo>>

    suspend fun insertTodo(todo: Todo)

    suspend fun deleteTodo(todo: Todo)
}