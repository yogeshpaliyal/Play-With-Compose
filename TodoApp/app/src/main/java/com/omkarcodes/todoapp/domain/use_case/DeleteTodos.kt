package com.omkarcodes.todoapp.domain.use_case

import com.omkarcodes.todoapp.domain.model.Todo
import com.omkarcodes.todoapp.domain.repository.TodoRepository

class DeleteTodos(
    private val repository: TodoRepository
) {

    suspend operator fun invoke(todo: Todo) {
        repository.deleteTodo(todo)
    }

}