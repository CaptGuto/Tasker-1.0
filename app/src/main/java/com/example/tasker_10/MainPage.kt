package com.example.tasker_10

import android.annotation.SuppressLint
import android.health.connect.datatypes.units.Length
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RestrictTo
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tasker_10.db.Task
import com.example.tasker_10.db.TaskDatabase
import com.example.tasker_10.db.taskDao
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainPage : AppCompatActivity() {
    lateinit var taskEditText: EditText
    lateinit var descriptionEditText: EditText
    lateinit var addTaskBtn : Button
    lateinit var taskViewModel: TaskViewModel
    lateinit var mainRecyclerView: RecyclerView
    lateinit var mainRecyclerViewAdapter: TaskRecyclerViewAdapter


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)

        taskEditText = findViewById(R.id.etTaskName)
        descriptionEditText = findViewById(R.id.etTaskDescription)
        addTaskBtn = findViewById(R.id.btnAddTask)
        mainRecyclerView = findViewById(R.id.taskRecyclerView)

        val dao = TaskDatabase.getInstance(application).TaskDao()
        val factory = TaskViewModelFactory(dao)

        taskViewModel = ViewModelProvider(this, factory)[TaskViewModel::class.java]

        initiateRecyclerView()

        //The onClick listener for the add btn
        addTaskBtn.setOnClickListener{
            SaveTask()
        }

    }
    
    fun initiateRecyclerView(){
        mainRecyclerView.layoutManager = LinearLayoutManager(this)
        mainRecyclerViewAdapter = TaskRecyclerViewAdapter{
                selectedItem: Task -> DeleteTask(selectedItem)
        }
        mainRecyclerView.adapter = mainRecyclerViewAdapter

        getAllDataToRecyclerView()
    }

    fun getAllTasks(){
        var allTask = taskViewModel.allTasks
    }

    fun SaveTask(){
        // TODO: here the data will be retrived from the database using the viewModel and will be displayed on the respective widgets  
        Log.i("test101","this is working")
        val task =
            Task(0,
                taskEditText.text.toString(),
                descriptionEditText.text.toString(),
                false)

        taskViewModel.addTask(task)

        // TODO: The Toast is not working  
        Toast.makeText(applicationContext,"Task Saved Success",Toast.LENGTH_SHORT)
        taskEditText.text.clear()
        descriptionEditText.text.clear()
    }

    fun DeleteTask(task: Task){
        Toast.makeText(this,"task ${task.taskName} has been deleted", Toast.LENGTH_SHORT)
        taskViewModel.deleteTask(task)
    }


    fun getAllDataToRecyclerView(){
        taskViewModel.allTasks.observe(this) {
            mainRecyclerViewAdapter.setTask(it)
            mainRecyclerViewAdapter.notifyDataSetChanged()
        }
    }


}