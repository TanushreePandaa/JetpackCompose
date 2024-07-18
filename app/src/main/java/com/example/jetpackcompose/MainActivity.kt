package com.example.jetpackcompose


import android.os.Bundle
import android.service.controls.ControlsProviderService.TAG
import android.util.Log
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.text.input.KeyboardType
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
import com.google.firebase.Firebase
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthMissingActivityForRecaptchaException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.auth.PhoneAuthProvider.ForceResendingToken
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge()
        setContent {
            val userList = remember {
                mutableStateOf<List<User>>(emptyList())
            }
            LaunchedEffect(Unit) {
                fetchStudents { users ->
                    userList.value = users
                }
            }
            JetpackComposeTheme {
                // AddUserScreen()
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp)
                ) {
                    items(userList.value) { user ->
                        Text(text = "NAME: ${user.name}, Age: ${user.age}")
                    }
                }
            }
        }
    }

    val db = Firebase.firestore
    fun addUser(name: String, age: Int) {
        val user = User(
            name,
            age
        )  //user is an object of User class which takes the parameters name and age passed in addUser
        db.collection("users")
            .add(user)
            .addOnSuccessListener { docRef ->
                Log.d(TAG, "DOCUMENT SNAPSHOT ADDED WITH ID: ${docRef.id}")
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error Adding Document")

            }
    }

    fun fetchStudents(onResult: (List<User>) -> Unit) {
        db.collection("users")
            .get()
            .addOnSuccessListener { result ->
                val userList = result.map { document -> document.toObject(User::class.java) }
                onResult(userList)
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error getting document", e)
            }
    }

    @Composable
    fun AddUserScreen() {
        var name by remember { mutableStateOf("") }
        var age by remember {
            mutableStateOf("")
        }
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = name,
                onValueChange = { name = it },
                label = { Text(text = "ENTER NAME") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = age,
                onValueChange = { age = it },
                label = { Text(text = "ENTER AGE") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = {
                addUser(name, age.toInt())
            }) {
                Text(text = "Add User")
            }
        }
    }


    // DATA/MODEL CLASS
    data class User(
        val name: String = "",
        val age: Int = 0
    )
}

