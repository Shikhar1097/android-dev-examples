package com.application.activitylifecycle

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    lateinit var etmobnum: EditText
    lateinit var etpass: EditText
    lateinit var btnlogin: Button
    lateinit var txtforgotpass: TextView
    lateinit var txtregister: TextView

    val validmobnum = "8765681707"
    val validpass = arrayOf("password", "tony", "bruce", "steve")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        title = "Log In"

        etmobnum = findViewById(R.id.etmobnum)
        etpass = findViewById(R.id.etpass)
        btnlogin = findViewById(R.id.btnlogin)
        txtforgotpass = findViewById(R.id.txtforgotpass)
        txtregister = findViewById(R.id.txtregister)

        btnlogin.setOnClickListener {
            // reading input data from ui
            val enteredmobnum = etmobnum.text.toString()
            val enteredpass = etpass.text.toString()
            // connection to activities
            val intent = Intent(this@LoginActivity, AvengersActivity::class.java)
            var nameOfAvenger = "Avenger"

            if ((enteredmobnum == validmobnum)) {
                when {
                    enteredpass == validpass[1] -> {
                        nameOfAvenger = "Iron Man"
                        // sending data to activity
                        intent.putExtra("Name", nameOfAvenger)
                        // starting the activity
                        startActivity(intent)

                    }
                    enteredpass == validpass[2] -> {
                        nameOfAvenger = "Hulk"
                        // sending data to activity
                        intent.putExtra("Name", nameOfAvenger)
                        // starting the activity
                        startActivity(intent)

                    }
                    enteredpass == validpass[3] -> {
                        nameOfAvenger = "Captain America"
                        // sending data to activity
                        intent.putExtra("Name", nameOfAvenger)
                        // starting the activity
                        startActivity(intent)

                    }
                    enteredpass == validpass[0] -> {
                        nameOfAvenger = "Team"
                        // sending data to activity
                        intent.putExtra("Name", nameOfAvenger)
                        // starting the activity
                        startActivity(intent)

                    }
                    else -> {
                        Toast.makeText(this@LoginActivity, "Incorrect Password", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            } else {
                // display a toast
                Toast.makeText(this@LoginActivity, "Incorrect Credentials", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }
}