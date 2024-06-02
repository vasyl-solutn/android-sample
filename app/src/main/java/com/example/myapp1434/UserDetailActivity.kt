// File: app/src/main/java/com/example/myapp1434/UserDetailActivity.kt
package com.example.myapp1434

import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class UserDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)

        // Set up the toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Enable the back button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val nameTextView: TextView = findViewById(R.id.nameTextView)
        val usernameTextView: TextView = findViewById(R.id.usernameTextView)
        val emailTextView: TextView = findViewById(R.id.emailTextView)
        val phoneTextView: TextView = findViewById(R.id.phoneTextView)
        val websiteTextView: TextView = findViewById(R.id.websiteTextView)

        val name = intent.getStringExtra("name")
        val username = intent.getStringExtra("username")
        val email = intent.getStringExtra("email")
        val phone = intent.getStringExtra("phone")
        val website = intent.getStringExtra("website")

        nameTextView.text = name
        usernameTextView.text = username
        emailTextView.text = email
        phoneTextView.text = phone
        websiteTextView.text = website
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                // Handle the back button press
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
