package com.example.myapp1434

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapp1434.databinding.ActivityMainBinding
import com.example.myapp1434.db.AppDatabase
import com.example.myapp1434.model.User
import com.example.myapp1434.ui.UserAdapter
import com.example.myapp1434.ui.UserViewModel
import com.example.myapp1434.ui.UserViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val database by lazy { AppDatabase.getDatabase(this) }
    private val viewModel: UserViewModel by viewModels { UserViewModelFactory(database) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = UserAdapter(emptyList())
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        viewModel.users.observe(this) { users ->
            adapter.updateUsers(users)
        }

        // Example usage: Insert users
        binding.buttonFetchUsers.setOnClickListener {
            // Fetch users from your API and insert into the database
            val sampleUsers = listOf(
                User(1, getString(R.string.name), "johndoe", "john@example.com", "123-456-7890", "johndoe.com"),
                // Add more users
            )
            viewModel.insertUsers(sampleUsers)
        }

        // Example usage: Delete all users
        binding.buttonDeleteAllUsers.setOnClickListener {
            viewModel.deleteAllUsers()
        }
    }
}
