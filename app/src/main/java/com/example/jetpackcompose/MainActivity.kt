package com.example.jetpackcompose


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity<Bundle> : ComponentActivity() {
    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
       // enableEdgeToEdge()
        setContent {
            JetpackComposeTheme {
                Column(
                    modifier = Modifier.padding(20.dp)
                    ,
                    verticalArrangement =Arrangement.Center
                ) {
                    Text(text = "Hello Silicon", color = Color.Cyan, fontStyle = FontStyle.Italic)
                    Text(
                        text = "Tanu",
                        modifier = Modifier
                            .padding(20.dp)
                            .background(Color.LightGray)
                    )
                    Row(
                        modifier = Modifier
                            .background(Color.Magenta)
                            .border(2.dp, Color.Cyan, RectangleShape)
                            .padding(20.dp)
                            .fillMaxWidth(),
//                            .fillMaxSize()
                        horizontalArrangement = Arrangement.End

                    ) {
                        Text("Text with Alignment ")
                        Text("Text with Alignment")
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .background(Color.Yellow)
                            .padding(20.dp)
                            .fillMaxHeight(),
                        verticalArrangement = Arrangement.Bottom,

                        ) {
                        Row {
                            Text(text = "Hiiiiii!!!")
                            Column(
                                modifier = Modifier.padding(20.dp)


                            ) {
                                Text(text = "Silicon")
                                Text(text = "Sil")

                            }
                        }
                    }

                }
            }
        }
    }
}

private fun <Bundle> ComponentActivity.onCreate(savedInstanceState: Bundle?) {
    TODO("Not yet implemented")
}


//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    _04JetpackUILayoutTheme {
//        Greeting("Android")
//    }
//}



