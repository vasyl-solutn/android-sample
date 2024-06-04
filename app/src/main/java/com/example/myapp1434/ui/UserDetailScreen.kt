package com.example.myapp1434.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapp1434.model.User

@Composable
fun UserDetailsScreen(user: User) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Name: ${user.name}", style = MaterialTheme.typography.titleMedium)
            Text(text = "Email: ${user.email}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Username: ${user.username}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Phone: ${user.phone}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Website: ${user.website}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Company: ${user.company.name}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Address: ${user.address.street}, ${user.address.city}", style = MaterialTheme.typography.bodyMedium)
        }
    }
}
