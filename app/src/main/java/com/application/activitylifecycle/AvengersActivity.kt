package com.application.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class  AvengersActivity : AppCompatActivity() {

    lateinit var etmsg: EditText
    lateinit var btnsendmsg: Button
    lateinit var btnlogout: Button

    var titleName: String? = "The Avengers"
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_avengers)

        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)

        titleName = sharedPreferences.getString("Title", "Team")

        title = titleName

        etmsg = findViewById(R.id.etmsg)
        btnsendmsg = findViewById(R.id.btnsendmsg)
        btnlogout = findViewById(R.id.btnlogout)

        btnsendmsg.setOnClickListener {
            val enteredmsg = etmsg.text.toString()

            val intent = Intent(this@AvengersActivity, MessageActivity::class.java)
            intent.putExtra("Message", enteredmsg)
            startActivity(intent)
        }

        btnlogout.setOnClickListener {

            val intent = Intent(this@AvengersActivity, LoginActivity::class.java)
            startActivity(intent)
            sharedPreferences.edit().clear().apply()
            finish()
        }
    }
}