package com.example.week1

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.week1.adapter.FruitsAdapter
import com.example.week1.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.Loginbutton.setOnClickListener {
            val username: String = binding.editUserName.text.toString()
            val password: String = binding.editPassword.text.toString()
            if (username.isEmpty()) {
                binding.editUserName.error = "username cannot be empty"

            } else if (password.isEmpty()) {
                binding.editPassword.error = "username cannot be empty"
            } else {
                val intent = Intent(
                    this@LoginActivity,
                    DestinationActivity::class.java

                )
                intent.putExtra("username",username)
                intent.putExtra("password",password)
                startActivity(intent)
                finish()

            }

            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }
    }
}