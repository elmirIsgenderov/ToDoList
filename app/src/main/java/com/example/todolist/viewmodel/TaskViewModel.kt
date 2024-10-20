package com.example.todolist.viewmodel

import androidx.lifecycle.*
import com.example.todolist.model.TaskItem
import com.example.todolist.repository.TaskItemRepository
import kotlinx.coroutines.launch
import java.time.LocalDate


class TaskViewModel(private val repository: TaskItemRepository) : ViewModel() {
    val taskItems: LiveData<List<TaskItem>> = repository.allTaskItems.asLiveData()

    fun addTaskItem(taskItem: TaskItem) = viewModelScope.launch {
        repository.insertTaskItem(taskItem)
    }

    fun deleteTaskItem(taskItem: TaskItem) = viewModelScope.launch {
        repository.deleteTaskItem(taskItem)
    }

    fun updateTaskItem(taskItem: TaskItem) = viewModelScope.launch {
        repository.updateTaskItem(taskItem)
    }

    fun setCompleted(taskItem: TaskItem) = viewModelScope.launch {
        if (!taskItem.isCompleted())
            taskItem.completedDateString = TaskItem.dateFormatter.format(LocalDate.now())
        repository.updateTaskItem(taskItem)
    }
}
