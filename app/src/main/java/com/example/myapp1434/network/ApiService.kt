// File: app/src/main/java/com/example/myapp1434/network/ApiService.kt
package com.example.myapp1434.network

import com.example.myapp1434.model.User
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers(): List<User>
}
