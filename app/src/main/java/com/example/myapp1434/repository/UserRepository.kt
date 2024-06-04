package com.example.myapp1434.repository

import com.example.myapp1434.model.User
import com.example.myapp1434.network.RetrofitClient

class UserRepository {
    suspend fun getUsers(): List<User> {
        return RetrofitClient.apiService.getUsers()
    }
}
