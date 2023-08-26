package com.example.tasker_10

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tasker_10.db.Task

class TaskRecyclerViewAdapter(): RecyclerView.Adapter<TaskRecyclerViewAdapter.TaskViewHolder>() {
    private var TaskList = ArrayList<Task>()

    inner class TaskViewHolder(private val view: View): RecyclerView.ViewHolder(view){
        fun bind(task: Task){
            val tvName= view.findViewById<TextView>(R.id.tvName_Task)
            val tvDescription = view.findViewById<TextView>(R.id.tvTaskDescription)

            tvName.text = task.taskName
            tvDescription.text = task.taskDescription


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val inflate = LayoutInflater.from(parent.context)
        val listItem = inflate.inflate(R.layout.list_task,parent, false)
        return TaskViewHolder(listItem)
    }

    override fun getItemCount(): Int {
        return TaskList.size
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(TaskList[position])
    }

    fun setTask(task: List<Task>){
        TaskList.clear()
        TaskList.addAll(task)
    }
}