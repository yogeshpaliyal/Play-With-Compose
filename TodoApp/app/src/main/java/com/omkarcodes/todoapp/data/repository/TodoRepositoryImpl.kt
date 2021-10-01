package com.omkarcodes.todoapp.data.repository

import com.omkarcodes.todoapp.data.data_source.TodoDao
import com.omkarcodes.todoapp.domain.model.Todo
import com.omkarcodes.todoapp.domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow

class TodoRepositoryImpl(
    private val dao: TodoDao
) : TodoRepository {

    override fun getTodos(): Flow<List<Todo>> {
        return dao.getAllTodos()
    }

    override suspend fun insertTodo(todo: Todo) {
        dao.insertTodo(todo)
    }

    override suspend fun deleteTodo(todo: Todo) {
        dao.deleteTodo(todo)
    }
}