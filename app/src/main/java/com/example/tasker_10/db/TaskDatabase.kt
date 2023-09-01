package com.example.tasker_10.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Database(entities = [Task::class],version = 1, exportSchema = false)
abstract class TaskDatabase: RoomDatabase() {
    abstract fun TaskDao(): taskDao
    companion object {
        @Volatile
        private var INSTANCE: TaskDatabase? = null

        fun getInstance(context: Context): TaskDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        TaskDatabase::class.java,
                        "Task_data_database"
                    ).allowMainThreadQueries().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}