// File: app/src/main/java/com/example/myapp1434/repository/UserRepository.kt
package com.example.myapp1434.repository

import android.content.Context
import com.example.myapp1434.db.AppDatabase
import com.example.myapp1434.model.User
import com.example.myapp1434.network.RetrofitClient

class UserRepository(context: Context) {

    private val userDao = AppDatabase.getDatabase(context).userDao()

    suspend fun fetchUsersFromApi(): List<User> {
        return RetrofitClient.apiService.getUsers()
    }

    suspend fun getAllUsers(): List<User> {
        return userDao.getAllUsers()
    }

    suspend fun insertUsers(users: List<User>) {
        userDao.insertUsers(users)
    }

    suspend fun deleteAllUsers() {
        userDao.deleteAllUsers()
    }
}
