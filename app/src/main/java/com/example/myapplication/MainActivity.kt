package com.example.myapplication

import android.annotation.SuppressLint
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bindingClass : ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        bindingClass.add.setOnClickListener {
            val newTodo = bindingClass.todo.text.toString()
            if (!TextUtils.isEmpty(newTodo)) {
                if (TextUtils.isEmpty(bindingClass.todo1.text)) {
                    bindingClass.todo1.text = "1. $newTodo"
                    bindingClass.remove1.visibility = View.VISIBLE
                }else if (TextUtils.isEmpty(bindingClass.todo2.text)) {
                    bindingClass.todo2.text = "2. $newTodo"
                    bindingClass.remove2.visibility = View.VISIBLE
                }else if (TextUtils.isEmpty(bindingClass.todo3.text)) {
                    bindingClass.todo3.text = "3. $newTodo"
                    bindingClass.remove3.visibility = View.VISIBLE
                }else if (TextUtils.isEmpty(bindingClass.todo4.text)) {
                    bindingClass.todo4.text = "4. $newTodo"
                    bindingClass.remove4.visibility = View.VISIBLE
                }else if (TextUtils.isEmpty(bindingClass.todo5.text)) {
                    bindingClass.todo5.text = "5. $newTodo"
                    bindingClass.remove5.visibility = View.VISIBLE
                }else if (TextUtils.isEmpty(bindingClass.todo6.text)) {
                    bindingClass.todo6.text = "6. $newTodo"
                    bindingClass.remove6.visibility = View.VISIBLE
                }else if (TextUtils.isEmpty(bindingClass.todo7.text)) {
                    bindingClass.todo7.text = "7. $newTodo"
                    bindingClass.remove7.visibility = View.VISIBLE
                }else if (TextUtils.isEmpty(bindingClass.todo8.text)) {
                    bindingClass.todo8.text = "8. $newTodo"
                    bindingClass.remove8.visibility = View.VISIBLE
                }else if (TextUtils.isEmpty(bindingClass.todo9.text)) {
                    bindingClass.todo9.text = "9. $newTodo"
                    bindingClass.remove9.visibility = View.VISIBLE
                }else if (TextUtils.isEmpty(bindingClass.todo10.text)) {
                    bindingClass.todo10.text = "10. $newTodo"
                    bindingClass.remove10.visibility = View.VISIBLE
                }
            } else {
                    val dialogBuilder=AlertDialog.Builder(this)
                    dialogBuilder.setTitle("Warning")
                    dialogBuilder.setMessage("Please write something...")
                    dialogBuilder.setPositiveButton("Ok"){ dialogInterface: DialogInterface, i: Int ->
                        Toast.makeText(this,"Thanks for understanding",Toast.LENGTH_LONG).show()
                    }
                    dialogBuilder.create().show()
            }
        }

        bindingClass.remove1.setOnClickListener{
            bindingClass.todo1.text = ""
            bindingClass.remove1.visibility = View.INVISIBLE
        }
        bindingClass.remove2.setOnClickListener{
            bindingClass.todo2.text = ""
            bindingClass.remove2.visibility = View.INVISIBLE
        }
        bindingClass.remove3.setOnClickListener{
            bindingClass.todo3.text = ""
            bindingClass.remove3.visibility = View.INVISIBLE
        }
        bindingClass.remove4.setOnClickListener{
            bindingClass.todo4.text = ""
            bindingClass.remove4.visibility = View.INVISIBLE
        }
        bindingClass.remove5.setOnClickListener{
            bindingClass.todo5.text = ""
            bindingClass.remove5.visibility = View.INVISIBLE
        }
        bindingClass.remove6.setOnClickListener{
            bindingClass.todo6.text = ""
            bindingClass.remove6.visibility = View.INVISIBLE
        }
        bindingClass.remove7.setOnClickListener{
            bindingClass.todo7.text = ""
            bindingClass.remove7.visibility = View.INVISIBLE
        }
        bindingClass.remove8.setOnClickListener{
            bindingClass.todo8.text = ""
            bindingClass.remove8.visibility = View.INVISIBLE
        }
        bindingClass.remove9.setOnClickListener{
            bindingClass.todo9.text = ""
            bindingClass.remove9.visibility = View.INVISIBLE
        }
        bindingClass.remove10.setOnClickListener{
            bindingClass.todo10.text = ""
            bindingClass.remove10.visibility = View.INVISIBLE
        }
    }
}
