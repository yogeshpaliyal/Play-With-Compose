package com.omkarcodes.todoapp.domain.use_case

import com.omkarcodes.todoapp.domain.model.Todo
import com.omkarcodes.todoapp.domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow

class GetTodos(
    private val repository: TodoRepository
) {

    operator fun invoke() : Flow<List<Todo>> {
        return repository.getTodos()
    }

}