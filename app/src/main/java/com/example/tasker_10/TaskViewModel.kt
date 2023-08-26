package com.example.tasker_10

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tasker_10.db.Task
import com.example.tasker_10.db.taskDao
import kotlinx.coroutines.launch

class TaskViewModel(private var dao: taskDao):ViewModel() {
    private var allTasks = dao.getAllTask()

    fun addTask(task : Task) = viewModelScope.launch{
        dao.insert(task)
    }

    fun deleteTask(task: Task) = viewModelScope.launch{
        dao.delete(task)
    }

    fun updateTask(task: Task) = viewModelScope.launch{
        dao.update(task)
    }
}