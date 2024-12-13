package com.example.week1

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class listActivity : AppCompatActivity() {
    lateinit var listView:ListView

    var contacts = arrayOf("Ram","Shyam","Hari","Gita",
        "Ram","Shyam","Hari","Gita",
        "Ram","Shyam","Hari","Gita",
        "Ram","Shyam","Hari","Gita",
        "Ram","Shyam","Hari","Gita",
        "Ram","Shyam","Hari","Gita",
        "Ram","Shyam","Hari","Gita",
        "Ram","Shyam","Hari","Gita",
        "Ram","Shyam","Hari","Gita",
        "Ram","Shyam","Hari","Gita",
        "Ram","Shyam","Hari","Gita",
        "Ram","Shyam","Hari","Gita",
        "Ram","Shyam","Hari","Gita",
        "Ram","Shyam","Hari","Gita",
        "Ram","Shyam","Hari","Gita",
        "Ram","Shyam","Hari","Gita",
        "Ram","Shyam","Hari","Gita",
        "Ram","Shyam","Hari","Gita",
        "Ram","Shyam","Hari","Gita",
        "Ram","Shyam","Hari","Gita",
        "Ram","Shyam","Hari","Gita",
        "Ram","Shyam","Hari","Gita",
        "Ram","Shyam","Hari","Gita",
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list)
        listView = findViewById(R.id.listView)

        val adapter = ArrayAdapter(
            this@listActivity,
            android.R.layout.simple_list_item_1,contacts
        )

        listView.adapter = adapter

        listView.setOnItemClickListener { parent, p1, position, l ->
            if(parent!=null){
                Toast.makeText(this@listActivity,parent.getItemAtPosition(position).toString(),Toast.LENGTH_SHORT)
                    .show()
            }
        }





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.listView)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}