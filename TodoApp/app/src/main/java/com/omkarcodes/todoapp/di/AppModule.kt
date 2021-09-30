package com.omkarcodes.todoapp.di

import android.app.Application
import androidx.room.Room
import com.omkarcodes.todoapp.data.data_source.TodoDatabase
import com.omkarcodes.todoapp.data.repository.TodoRepositoryImpl
import com.omkarcodes.todoapp.domain.repository.TodoRepository
import com.omkarcodes.todoapp.domain.use_case.CreateORUpdateTodos
import com.omkarcodes.todoapp.domain.use_case.DeleteTodos
import com.omkarcodes.todoapp.domain.use_case.GetTodos
import com.omkarcodes.todoapp.domain.use_case.TodoUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideTodoDatabase(app: Application) : TodoDatabase =
        Room.databaseBuilder(
            app,
            TodoDatabase::class.java,
            TodoDatabase.DATABASE_NAME
        ).build()

    @Provides
    @Singleton
    fun provideTodoRepository(db: TodoDatabase) : TodoRepository = TodoRepositoryImpl(db.todoDao)

    @Provides
    @Singleton
    fun provideTodoUseCases(repository: TodoRepository) : TodoUseCases =
        TodoUseCases(
            getTodos = GetTodos(repository),
            createORUpdateTodos = CreateORUpdateTodos(repository),
            deleteTodos = DeleteTodos(repository)
        )

}