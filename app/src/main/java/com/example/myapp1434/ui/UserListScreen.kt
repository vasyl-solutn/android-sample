package com.example.myapp1434.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapp1434.model.User
import com.example.myapp1434.viewmodel.UserViewModel

@Composable
fun UserListScreen(onUserClick: (User) -> Unit) {
    val userViewModel: UserViewModel = viewModel()
    val users = userViewModel.users.collectAsState().value

    LazyColumn {
        items(users) { user ->
            UserItem(user, onUserClick)
        }
    }
}

@Composable
fun UserItem(user: User, onUserClick: (User) -> Unit) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onUserClick(user) },
        color = MaterialTheme.colorScheme.background,
        tonalElevation = 2.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = user.name, style = MaterialTheme.typography.titleMedium)
            Text(text = user.email, style = MaterialTheme.typography.bodyMedium)
        }
    }
}
