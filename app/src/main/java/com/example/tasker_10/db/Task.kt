package com.example.tasker_10.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task_table")
data class Task(
    @PrimaryKey(autoGenerate = true)
    var taskId : Int,
    var taskName: String,
    var taskDescription : String,
    var isTaskDone: Boolean
)
