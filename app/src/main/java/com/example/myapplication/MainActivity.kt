package com.example.myapplication

import android.annotation.SuppressLint
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var bindingClass: ActivityMainBinding
    private lateinit var todoAdapter: TodoAdapter

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
        todoAdapter = TodoAdapter(mutableListOf())

        todoItems.adapter = todoAdapter
        todoItems.layoutManager = LinearLayoutManager(this)

        addTodo.setOnClickListener {
            val newTodo = addTodoTitle.text.toString()
            if (newTodo.isNotEmpty()) {
                val todo = Todo(newTodo)
                todoAdapter.addTodo(todo)
                addTodoTitle.text.clear()
            } else {
                val dialogBuilder = AlertDialog.Builder(this)
                dialogBuilder.setTitle("Warning")
                dialogBuilder.setMessage("Please write something...")
                dialogBuilder.setPositiveButton("Ok") { dialogInterface: DialogInterface, i: Int ->
                    Toast.makeText(this, "Thanks for understanding", Toast.LENGTH_LONG).show()
                }
                dialogBuilder.create().show()
            }
        }

        removeTodo.setOnClickListener {
            todoAdapter.deleteTodos()
        }
    }
}
