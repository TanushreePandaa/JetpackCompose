package com.example.jetpackcompose.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcompose.Model.API.RetrofitClient
import com.example.jetpackcompose.Model.Data.Product
import com.example.jetpackcompose.Model.Repository.ProductRepository
import kotlinx.coroutines.launch

class ProductViewModel: ViewModel() {
    private val _products = MutableLiveData<List<Product>>() //products->live data
    val products: LiveData<List<Product>> get() = _products // actual products which will be exposed to UI

    private val repository =
        ProductRepository(RetrofitClient.apiService) //repository get the objects of API service

    init {
        fetchProducts()
    }

    fun fetchProducts() {
        viewModelScope.launch {
            try {
                val productList = repository.getProducts()
                _products.postValue(productList)
                println("API DATA CALLED: $productList")
            } catch (e: Exception) {

            }
        }
    }
}