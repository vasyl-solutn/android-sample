// File: app/src/main/java/com/example/myapp1434/ui/MainActivity.kt
package com.example.myapp1434

import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.myapp1434.ui.UserViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textViewName: TextView = findViewById(R.id.textViewName)
        val textViewEmail: TextView = findViewById(R.id.textViewEmail)
        val button: Button = findViewById(R.id.button)
        val progressBar: ProgressBar = findViewById(R.id.progressBar)

        viewModel.user.observe(this) { user ->
            textViewName.text = "Name: ${user.name}"
            textViewEmail.text = "Email: ${user.email}"
            progressBar.visibility = ProgressBar.GONE
        }

        viewModel.error.observe(this) { error ->
            Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
            progressBar.visibility = ProgressBar.GONE
        }

        viewModel.loading.observe(this) { isLoading ->
            if (isLoading) {
                progressBar.visibility = ProgressBar.VISIBLE
            } else {
                progressBar.visibility = ProgressBar.GONE
            }
        }

        button.setOnClickListener {
            viewModel.fetchUser(7) // Fetch user with ID 1
        }
    }
}
