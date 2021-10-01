package com.omkarcodes.todoapp.presentation.home_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.omkarcodes.todoapp.domain.model.Todo
import com.omkarcodes.todoapp.domain.use_case.TodoUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val todoUseCases: TodoUseCases
) : ViewModel() {

    private val _state = mutableStateOf(listOf<Todo>())
    val state: State<List<Todo>> = _state

    private var getTodosJob: Job? = null

    init {
        getNotes()
    }

    private fun getNotes() {
        getTodosJob?.cancel()
        getTodosJob = todoUseCases.getTodos()
            .onEach { todos ->
                _state.value = todos.sortedBy { it.isChecked }
            }
            .launchIn(viewModelScope)
    }

    fun insertOrUpdateTodo(todo: Todo) {
        viewModelScope.launch {
            todoUseCases.createORUpdateTodos(todo)
        }
    }

    fun deleteTodo(todo: Todo) {
        viewModelScope.launch {
            todoUseCases.deleteTodos(todo)
        }
    }
}