package com.example.myapp1434

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myapp1434.ui.UserDetailsScreen
import com.example.myapp1434.ui.UserListScreen
import com.example.myapp1434.ui.theme.MyApp1434Theme
import com.example.myapp1434.model.User

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp1434Theme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    val users = remember {
        listOf(
            User(1, "John Doe", "johndoe", "john@example.com", "123-456-7890", "johnswebsite.com"),
            User(2, "Jane Smith", "janesmith", "jane@example.com", "098-765-4321", "janeswebsite.com")
        )
    }

    NavHost(navController = navController, startDestination = "userList") {
        composable("userList") {
            UserListScreen(users = users) { user ->
                navController.navigate("userDetails/${user.name}/${user.email}")
            }
        }
        composable(
            route = "userDetails/{name}/{email}",
            arguments = listOf(
                navArgument("name") { type = NavType.StringType },
                navArgument("email") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: ""
            val email = backStackEntry.arguments?.getString("email") ?: ""
            val user = users.find { it.name == name && it.email == email }
            user?.let { UserDetailsScreen(user = it) }
        }
    }
}
