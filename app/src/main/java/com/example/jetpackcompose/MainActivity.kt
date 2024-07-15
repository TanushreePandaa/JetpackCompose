package com.example.jetpackcompose


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcompose.Model.Data.Product
import com.example.jetpackcompose.ViewModels.ProductViewModel
import com.example.jetpackcompose.ViewModels.UserViewModel
import com.example.jetpackcompose.Views.productScreen
import com.example.jetpackcompose.Views.UserScreen
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme
import kotlinx.coroutines.launch

class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge()
        setContent {
            val productVM : ProductViewModel by viewModels()
            val userVM: UserViewModel by viewModels()
            JetpackComposeTheme {
               //productScreen(productVM = productVM)
             UserScreen(userVM = userVM)
//                Column(
//                    modifier = Modifier
//                        .padding(20.dp)
//                        .fillMaxSize(),
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                    verticalArrangement = Arrangement.Center
//                ) {
//                     Button(onClick = {
//                        productVM.fetchProducts()
//                    }) {
//                        Text(text = "Click to make an API call")
//
//                    }

                }
            }
        }
    }

