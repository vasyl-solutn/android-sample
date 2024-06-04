package com.example.myapp1434

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myapp1434.model.User
import com.example.myapp1434.ui.UserDetailsScreen
import com.example.myapp1434.ui.UserListScreen
import com.example.myapp1434.ui.theme.MyApp1434Theme
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp1434Theme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "userList") {
                    composable("userList") {
                        UserListScreen { user ->
                            val userJson = Gson().toJson(user)
                            navController.navigate("userDetails/$userJson")
                        }
                    }
                    composable(
                        route = "userDetails/{userJson}",
                        arguments = listOf(navArgument("userJson") { type = NavType.StringType })
                    ) { backStackEntry ->
                        val userJson = backStackEntry.arguments?.getString("userJson") ?: ""
                        val userType = object : TypeToken<User>() {}.type
                        val user = Gson().fromJson<User>(userJson, userType)
                        UserDetailsScreen(user = user)
                    }
                }
            }
        }
    }
}
