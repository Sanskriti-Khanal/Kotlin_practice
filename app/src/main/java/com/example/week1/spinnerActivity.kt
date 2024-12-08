package com.example.week1

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class spinnerActivity : AppCompatActivity(),AdapterView.OnItemSelectedListener{
    lateinit var spinner: Spinner
    lateinit var textView: TextView


    var countries = arrayOf("Nepal","China","Bhutan","Pakistan","Canada","India","Australia")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_spinner)
        spinner = findViewById(R.id.spinner)
        textView = findViewById(R.id.displaySpinner)

        val adapter = ArrayAdapter(
            this@spinnerActivity,
            android.R.layout.simple_list_item_1,
            countries
        )
        adapter.setDropDownViewResource(
            android.R.layout.simple_dropdown_item_1line
        )
        spinner.adapter = adapter
        spinner.onItemSelectedListener=this

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
       if(parent != null){
           textView.text=
               parent.getItemAtPosition(position).toString()
       }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }
}