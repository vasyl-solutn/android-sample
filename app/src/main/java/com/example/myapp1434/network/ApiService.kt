package com.example.myapp1434.network

import com.example.myapp1434.model.User
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("users/{id}")
    suspend fun getUser(@Path("id") userId: Int): User
}