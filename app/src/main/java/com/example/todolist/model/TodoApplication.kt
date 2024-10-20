package com.example.todolist.model

import android.app.Application
import com.example.todolist.database.TaskItemDatabase
import com.example.todolist.repository.TaskItemRepository

class TodoApplication : Application() {
    private val database by lazy { TaskItemDatabase.getDatabase(this) }
    val repository by lazy { TaskItemRepository(database.taskItemDao()) }
}