package com.example.jetpackcompose


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge()
        setContent {
        JetpackComposeTheme {
            Column {
                AppNavigation()
                CounterScreen()
            }

        }
    }
}

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "screen1") {
        composable("screen1"){Screen1(navController)}
        composable("screen2"){Screen2(navController)}
        composable("screen3"){Screen3(navController)}
        composable("screen4/{data}", arguments = listOf(navArgument("data"){type= NavType.StringType}))
        {backstackentry ->
            Screen4(navController, backstackentry.arguments?.getString("data") ?: "a")
        }
        composable("screen5"){Screen5(navController)}

    }
}

@Composable
fun Screen5(navController: NavHostController){
    val itemsList = List(100){"item = $it"}
    Column(modifier = Modifier.fillMaxWidth().padding(20.dp)
    ) {
        Button(onClick = { navController.navigate("screen1") }) {
            Text(text = "Go to screen1")
        }
        LazyVerticalGrid(columns = GridCells.Adaptive(120.dp)) {
            items(itemsList){
                Card {
                    Text(text = it)
                }
            }
        }
    }

}

@Composable
fun Screen4(navController: NavHostController, data: String?) {
    Column {
        Text(text = "This is Screen4  and the data is $data", fontSize = 30.sp, color = Color.Green)
        Button(onClick = { navController.navigate("screen5") }) {
            Text(text = "Go to screen5")
        }
    }
}

@Composable
fun Screen3(navController: NavHostController) {
    Column {
        var text by remember {
            mutableStateOf("")
        }
        Text(text = "This is Screen3", fontSize = 30.sp, color = Color.Cyan)
        OutlinedTextField(value = text, onValueChange = {
            text = it
        })
        Button(onClick = { navController.navigate("screen4/$text") }) {
            Text(text = "Go to screen4")
        }
    }
}

@Composable
fun Screen2(navController: NavHostController) {
    Column {
        Text(text = "This is Screen2", fontSize = 30.sp, color = Color.Blue)
        Button(onClick = { navController.navigate("screen3") }) {
            Text(text = "Go to screen3")
        }
    }
}


@Composable
fun Screen1(navController: NavHostController) {
    Column {
        Text(text = "This is Screen1", fontSize = 30.sp, color = Color.Red)
        Button(onClick = { navController.navigate("screen2") }) {
            Text(text = "Go to screen2")
        }
    }
}

@Composable
fun CounterScreen(){
    var count by remember {
        mutableIntStateOf(0)
    }
    var text by rememberSaveable { mutableStateOf("") }
    Column(
        modifier= Modifier
            .padding(16.dp)
            .fillMaxSize(),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
    ){
        Text(text = "The count is $count")
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = { count++ }) {
            Text(text = "Increment")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = { count-- }) {
            Text(text = "Decrement")
        }
        OutlinedTextField(
            value = text,
            onValueChange = { text =it },
            label = { Text("Enter Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
    }
}
        }
