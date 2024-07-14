package com.example.jetpackcompose.Model.API

import com.example.jetpackcompose.Model.Data.Product
import com.example.jetpackcompose.Model.Data.User
import retrofit2.http.GET

interface ApiService {
    @GET("products")
    suspend fun getProducts(): List<Product>
    @GET("users")
    suspend fun getUsers(): List<User>
}