package com.omkarcodes.todoapp.domain.use_case

data class TodoUseCases(
    val getTodos: GetTodos,
    val createORUpdateTodos: CreateORUpdateTodos,
    val deleteTodos: DeleteTodos
)

