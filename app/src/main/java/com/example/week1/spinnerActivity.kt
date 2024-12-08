package com.example.week1

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class spinnerActivity : AppCompatActivity(),AdapterView.OnItemSelectedListener{
    lateinit var spinner: Spinner
    lateinit var textView: TextView
    lateinit var autoCompleteTextView: AutoCompleteTextView
    lateinit var date: EditText


    var countries = arrayOf("Nepal","China","Bhutan","Pakistan","Canada","India","Australia")
    var cities = arrayOf("Kathamandu","Bhaktapur","lalitpur","Kritipur","Kanchanpur")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_spinner)
        spinner = findViewById(R.id.spinner)
        textView = findViewById(R.id.displaySpinner)
        autoCompleteTextView = findViewById(R.id.autoCompleteTextView2)
        date = findViewById(R.id.editTextDate)


        date.isClickable = true
        date.isFocusable = false
        date.setOnClickListener{
            loadCalendar()
        }

        val autoAdapter = ArrayAdapter(
            this@spinnerActivity,
            android.R.layout.simple_list_item_1,
            cities

        )

        autoCompleteTextView.setAdapter(autoAdapter)
        autoCompleteTextView.threshold=2

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

    private fun loadCalendar() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val dialog = DatePickerDialog(
            this@spinnerActivity,
            DatePickerDialog.OnDateSetListener
            { datePicker, year, month, day ->

                date.setText("$year/${month+1}/$day")
            },year,month,day
        )
        dialog.show()
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