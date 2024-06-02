// File: app/src/main/java/com/example/myapp1434/UserDetailActivity.kt
package com.example.myapp1434

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class UserDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)

        val nameTextView: TextView = findViewById(R.id.nameTextView)
        val emailTextView: TextView = findViewById(R.id.emailTextView)

        val name = intent.getStringExtra("name")
        val email = intent.getStringExtra("email")

        nameTextView.text = name
        emailTextView.text = email
    }
}
