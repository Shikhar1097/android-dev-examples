package com.application.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MessageActivity : AppCompatActivity() {

    lateinit var txtmsg: TextView
    var msg: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)

        title = "Message"

        txtmsg = findViewById(R.id.txtmsg)

        if (intent != null) {
            msg = intent.getStringExtra("Message")
        }

        txtmsg.text = msg
    }
}