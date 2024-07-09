package com.example.jetpackcompose


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // enableEdgeToEdge()
        setContent {
            ScaffoldExample()

        }
    }


}



@Composable
fun Card() {
    Column {
        ElevatedCard(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),

            ) {
            Box(modifier = Modifier
                .background(colorResource(id = R.color.white))
            ){
                Column {
                    Text(
                        text = "Jetpack Compose ",
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        color = colorResource(id = R.color.teal_700),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 30.sp,
                        textAlign = TextAlign.Center,
                    )
                    Column(modifier = Modifier
                        .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(painter = painterResource(id = R.drawable.logo),
                            contentDescription = "Jetpack Compose " ,
                            modifier = Modifier
                                .size(150.dp)
                                .fillMaxWidth(),
                            contentScale = ContentScale.Fit
                        )
                    }
                    Text(
                        text = "Login ",
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Start,
                        fontSize = 40.sp,
                        color = colorResource(id = R.color.newcolor1)
                    )
                    var text by remember { mutableStateOf("") }

                    Column(
                        modifier = Modifier
                            .padding(20.dp)
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        OutlinedTextField(value = text,
                            onValueChange = { text = it },
                            label = {
                                Text(
                                    "Email Id or Mobile no. ",
                                    fontSize = 20.sp
                                )
                            },
                            placeholder = { Text(text = "xyz@gmail.com")}
                        )
                        //Text(text)
                        Spacer(modifier = Modifier.height(20.dp))
                        var password by rememberSaveable { mutableStateOf("") }


                        OutlinedTextField(
                            value = text,
                            trailingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = null) },
                            onValueChange = {
                                text = it
                            },
                            label = { Text(text = "Password") },
                            placeholder = { Text(text = "Enter your Password") },
                        )

                    }/*
                    Spacer(modifier = Modifier.height(20.dp) )
                    Icon(Icons.Filled.Lock,
                        "Floating action button." ,
                        Modifier
                            .size(50.dp)
                            .fillMaxWidth(),
                        tint = colorResource(id = R.color.Green2)) */

                    Text(
                        text = "Forgot Pasword ? ",
                        modifier = Modifier
                            .padding(5.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.End,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W700 ,
                        color = colorResource(id = R.color.newcolor1)
                    )

                    Button(onClick = { println("Login") } ,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.newcolor)
                        ),
                        modifier = Modifier
                            .padding(20.dp)
                            .width(130.dp)
                            .height(60.dp)

                    ) {
                        Text(text = "Login" , fontSize = 20.sp)
                    }
                }
            }
        }//Card End
        Spacer(modifier = Modifier.height(30.dp))
        Row(modifier = Modifier
            .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Don't have an account ? " , fontSize = 18.sp)
            Text(text = " Register" , fontSize = 18.sp, fontWeight = FontWeight.W700, color = colorResource(
                id = R.color.teal_700) )
        }

    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldExample() {
    var presses by remember { mutableIntStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = colorResource(id = R.color.teal_700),
                    titleContentColor = colorResource(id = R.color.purple_200),
                ),

                title = {
                    Text("Jetpack",
                        textAlign = TextAlign.Center,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,)
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = colorResource(id = R.color.teal_700),
                contentColor = colorResource(id = R.color.white),
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = "Register",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    //color = colorResource(id = R.color.teal_700)
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { presses++ }) {
                Box(modifier = Modifier
                    .background(colorResource(id = R.color.teal_200 ))
                    .size(60.dp) ,
                    Alignment.Center
                ){
                    Icon(Icons.Default.Call, contentDescription = "Add")
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            /* Text(
                 modifier = Modifier.padding(8.dp),
                 text =
                 """
                     This is an example of a scaffold. It uses the Scaffold composable's parameters to create a screen with a simple top app bar, bottom app bar, and floating action button.
                     It also contains some basic inner content, such as this text.
                     You have pressed the floating action button $presses times.
                 """.trimIndent(),
             )
             */

            //Start of task app

            Column (
                modifier = Modifier
                    .padding(10.dp)
            ) {
                Card()
            }


            //End of task app

            /*
            var itemsList = List(10) { "items : $it" }
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "List")
                LazyColumn(
                    modifier = Modifier
                        .height(400.dp)
                        .width(100.dp)
                        .padding(5.dp)
                        .border(2.dp, Color.Black)
                ) {
                    items(itemsList) { item ->
                        BasicText(text = item, modifier = Modifier.padding(2.dp))
                    }
                }

                /*

                var text by remember {
                    mutableStateOf("")
                }

                Column(
                    modifier = Modifier
                        .padding(20.dp)
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    TextField(value = text,
                        onValueChange = { text = it },
                        label = { Text("Username: ") }
                    )
                    Text(text)
                }
                 */
*/
        }
    }
}
