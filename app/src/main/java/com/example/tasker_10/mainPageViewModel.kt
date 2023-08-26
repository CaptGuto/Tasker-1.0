package com.example.tasker_10

import android.app.Application
import androidx.lifecycle.ViewModel
import com.example.tasker_10.db.TaskDatabase
import com.example.tasker_10.db.taskDao

class mainPageViewModel():ViewModel() {
    lateinit var dao: taskDao


}