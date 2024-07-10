package com.example.jetpackcompose


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme
import kotlin.math.floor
import kotlin.reflect.KProperty

class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge()
        setContent {
            //JetpackComposeTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                CounterView()
            }
        }
    }
}

    @Composable
    fun CounterView(counterVM: CounterViewModel = viewModel()) {
        val intContent = GenericClass(120)
        val stringContent = GenericClass("Hello Tanu")
        val counterState = counterVM.counter.value
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Current counter value: ${counterState.count}")
            Row {
                Button(onClick = {
                    counterVM.incrementCounter()
                }) {
                    Text(text = "Increment Value")
                }
                Spacer(modifier = Modifier.width(20.dp))
                Button(onClick = {
                    counterVM.decrementCounter()
                }) {
                    Text(text = "Decrement Value")
                }
                Spacer(modifier = Modifier.width(20.dp))
            }
            Button(onClick = {
                counterVM.login()
                println("${intContent.content}, ${stringContent.content}")
            }) {
                Text(text = "Login Button")
            }
        }
    }
//Model Class
data class Counter(val count: Int)
data class User(val username: String, val password: String)

//ViewModel Class
class CounterViewModel : ViewModel() {
    private val _counter = mutableStateOf(Counter(0))
    val counter: State<Counter> = _counter

    fun incrementCounter() {
        _counter.value = Counter(_counter.value.count + 1)
    }

    fun decrementCounter() {
        _counter.value = Counter(_counter.value.count - 1)
    }
    fun resetCounter(){
        _counter.value = Counter(0)
    }
    fun login(){
        //login logic
    }
}
class GenericClass<T>(var content: T)