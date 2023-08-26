package com.example.tasker_10

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tasker_10.db.taskDao
import java.lang.IllegalArgumentException

class TaskViewModelFactory(
    private val dao: taskDao
):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(TaskViewModel::class.java)){
            return TaskViewModel(dao) as T
        }
        else throw IllegalArgumentException("Unknown View Model Class")
    }
}