package com.application.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
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

    lateinit var sharedPreferences: SharedPreferences

    val validmobnum = "8765681707"
    val validpass = arrayOf("password", "tony", "bruce", "steve")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences =
            getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)

        // to get the value of isLoggedIn from sharedpreferences, default value is given as false
        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)

        // setting the layout file associated
        setContentView(R.layout.activity_login)

        if (isLoggedIn) {
            val intent = Intent(this@LoginActivity, AvengersActivity::class.java)
            startActivity(intent)
            finish()
        }

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
                        savePreferences(nameOfAvenger)
                        // sending data to activity
                        intent.putExtra("Name", nameOfAvenger)
                        // starting the activity
                        startActivity(intent)

                    }
                    enteredpass == validpass[2] -> {
                        nameOfAvenger = "Hulk"
                        savePreferences(nameOfAvenger)
                        // sending data to activity
                        intent.putExtra("Name", nameOfAvenger)
                        // starting the activity
                        startActivity(intent)

                    }
                    enteredpass == validpass[3] -> {
                        nameOfAvenger = "Captain America"
                        savePreferences(nameOfAvenger)
                        // sending data to activity
                        intent.putExtra("Name", nameOfAvenger)
                        // starting the activity
                        startActivity(intent)

                    }
                    enteredpass == validpass[0] -> {
                        nameOfAvenger = "Team"
                        savePreferences(nameOfAvenger)
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

        txtforgotpass.setOnClickListener {  }

        txtregister.setOnClickListener {  }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }

    fun savePreferences(title: String) {
        sharedPreferences.edit().putBoolean("isLoggedIn", true).apply()
        sharedPreferences.edit().putString("Title", title).apply()
    }
}