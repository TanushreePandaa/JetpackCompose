package com.example.jetpackcompose


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.PasswordVisualTransformation
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
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch

class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge()
        setContent {
            JetpackComposeTheme {
                loginScreen()
            }
        }
    }

    val auth = FirebaseAuth.getInstance()
    fun signIn(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener { task ->
                if (task.user != null) {
                    println("User Logged In")
                    var user = auth.currentUser
                    println(user?.uid)
                }
            }
    }

    fun signUp(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener { task ->
                if (task.user != null) {
                    println("User Created")
                    var user = auth.currentUser
                    println(user?.uid)
                }
            }
    }

    @Composable
    fun loginScreen() {
        var email = remember {
            mutableStateOf("")
        }
        var password = remember {
            mutableStateOf("")
        }
        Scaffold { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
            ) {
                Card(modifier = Modifier.fillMaxSize()) {
                    TextField(
                        value = email.value,
                        onValueChange = { email.value = it },
                        label = { Text(text = "Email") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(CircleShape)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = password.value,
                        onValueChange = { password.value = it },
                        label = { Text(text = "Password") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(CircleShape),
                        visualTransformation = PasswordVisualTransformation()
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(onClick = { signUp(email.value, password.value) }) {
                        Text(text = "Register")
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(onClick = { signUp(email.value, password.value) }) {
                        Text(text = "Login")
                    }
                }
            }
        }
    }
}


