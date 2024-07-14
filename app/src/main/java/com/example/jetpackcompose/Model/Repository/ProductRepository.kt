package com.example.jetpackcompose.Model.Repository

import com.example.jetpackcompose.Model.API.ApiService
import com.example.jetpackcompose.Model.Data.Product


class ProductRepository(private val apiService: ApiService) {
    suspend fun getProducts(): List<Product> {
        return apiService.getProducts()
    }
}
