package com.example.week1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.week1.databinding.ActivityDestinationBinding
import com.example.week1.databinding.ActivityLoginBinding

class DestinationActivity : AppCompatActivity() {
    lateinit var binding: ActivityDestinationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDestinationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val username : String=
            intent.getStringExtra("username").toString()

        val password: String=
            intent.getStringExtra("password").toString()

        binding.outputUsername.text = username
        binding.outputpassword.text = password


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}