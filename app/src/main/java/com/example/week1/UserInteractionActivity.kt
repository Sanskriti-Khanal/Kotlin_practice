package com.example.week1

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class UserInteractionActivity : AppCompatActivity() {
    lateinit var buttonAlert : Button
    lateinit var buttonToast: Button
    lateinit var buttonSnack : Button
    lateinit var main : ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user_interaction)
        buttonAlert = findViewById(R.id.btnAlert)
        buttonToast = findViewById(R.id.btnToast)
        buttonSnack = findViewById(R.id.btnSnack)
        main = findViewById(R.id.listView)

        buttonAlert.setOnClickListener{
            val alert =  AlertDialog.Builder(this@UserInteractionActivity)
            alert.setTitle("Confirm")
                .setMessage("Are you sure, you want to logout?")
                .setIcon(R.drawable.apple)
                .setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which ->

                    //logout ko logic
                })
                .setNegativeButton("No",DialogInterface.OnClickListener
                { dialog, which ->
                    dialog.dismiss()

                })

            alert.create().show()

        }
        buttonToast.setOnClickListener{
            Toast.makeText(
                this@UserInteractionActivity,
                "Invalid Login Details",
                Toast.LENGTH_LONG
            ).show()
        }
        buttonSnack.setOnClickListener{
            Snackbar.make(main,
                "No Internet Connection",
                Snackbar.LENGTH_LONG).setAction("Retry",{
                    //logic if clicks retry
            }).show()




        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.listView)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}