package com.application.activitylifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class  AvengersActivity : AppCompatActivity() {

    lateinit var etmsg: EditText
    lateinit var btnsendmsg: Button

    var titleName: String? = "The Avengers"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_avengers)
        println("onCreate called")

        if (intent != null) {
            titleName = intent.getStringExtra("Name")
        }

        title = titleName

        etmsg = findViewById(R.id.etmsg)
        btnsendmsg = findViewById(R.id.btnsendmsg)

        btnsendmsg.setOnClickListener {
            val enteredmsg = etmsg.text.toString()

            val intent = Intent(this@AvengersActivity, MessageActivity::class.java)
            intent.putExtra("Message", enteredmsg)
            startActivity(intent)
        }
    }
}