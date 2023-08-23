package com.example.tasker_10.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface taskDao {
    @Insert
    fun insert(task: Task)
    @Update
    fun update(task: Task)
    @Delete
    fun delete(task: Task)

    @Query("select * from task_table")
    fun getAllTask(): LiveData<List<Task>>

}