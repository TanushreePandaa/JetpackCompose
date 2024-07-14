package com.example.jetpackcompose.Model.Repository

import com.example.jetpackcompose.Model.API.ApiService
import com.example.jetpackcompose.Model.Data.Product
import com.example.jetpackcompose.Model.Data.User


class UserRepository(private val apiService: ApiService) {
    suspend fun getUsers(): List<User> {
        return apiService.getUsers()
    }
}
