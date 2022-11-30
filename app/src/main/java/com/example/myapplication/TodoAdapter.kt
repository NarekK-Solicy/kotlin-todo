package com.example.myapplication

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_todo.view.*

class TodoAdapter(
    private var todos: MutableList<Todo>
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {
    class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_todo,
                parent,
                false
            )
        )
    }

    fun addTodo(todo: Todo) {
        todos.add(todo)
        notifyItemInserted(todos.size - 1)
    }

    fun deleteTodos() {
        val newTodos = todos.filter { !it.isChecked }
        todos = newTodos as MutableList<Todo>
        notifyItemRemoved(todos.size)
    }

    private fun toggleStrikeThrough(todoTitle: TextView, isChecked: Boolean) {
        if (isChecked) {
            todoTitle.paintFlags = todoTitle.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            todoTitle.paintFlags = todoTitle.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val curTodo = todos[position]
        holder.itemView.apply {
            newTodoTitle.text = curTodo.title
            chooseTodo.isChecked = curTodo.isChecked
            toggleStrikeThrough(newTodoTitle, curTodo.isChecked)
            chooseTodo.setOnCheckedChangeListener { _, isChecked ->
                toggleStrikeThrough(newTodoTitle, isChecked)
                curTodo.isChecked = !curTodo.isChecked
            }
        }
    }

    override fun getItemCount(): Int {
        return todos.size
    }
}