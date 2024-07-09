package com.example.jetpackcompose


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
//import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
//import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity<Bundle> : ComponentActivity() {
    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge()
        setContent {
            JetpackComposeTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
                    Column {
                        Text(text = "Tanushree-Panda", color = Color.Cyan, fontSize = 30.sp, fontStyle = FontStyle.Italic, fontWeight = FontWeight.Bold)
                        Text("Hello World", color = Color.Blue)
                        Text("Hello World", fontSize = 30.sp)
                        val offset = Offset(5.0f, 10.0f)
                        Text(
                            text = "Hello world!",
                            style = TextStyle(
                                fontSize = 24.sp,
                                shadow = Shadow(
                                    color = Color.Blue, offset = offset, blurRadius = 3f
                                )
                            )
                        )
                        MultipleStylesInText()
                        TextStyledBrushSnippet("The Text composable has multiple optional parameters to style its content. Below, we’ve listed parameters that cover the most common use cases with text. ")
//                    TextStyledBrushSnippet()
                        Text(
                            text = buildAnnotatedString {
                                append("Do not allow people to dim your shine\n")
                                val rainbowColors: List<Color> = listOf(Color.Red, Color.Blue)
                                withStyle(
                                    SpanStyle(
                                        brush = Brush.linearGradient(
                                            colors = rainbowColors
                                        )
                                    )
                                ) {
                                    append("because they are blinded.")
                                }
                                append("\nTell them to put some sunglasses on.")
                            }
                        )
                    }
                }
            }
        }

//    override fun onStart() {
//        super.onStart()
//        println("LifeCycle On Create Started")
//    }
//
//    override fun onResume() {
//        super.onResume()
//        println("LifeCycle On Resume Started")
//    }
//
//    override fun onPause() {
//        super.onPause()
//        println("LifeCycle On Pause Started")
//    }
//
//    override fun onStop() {
//        super.onStop()
//        println("LifeCycle On Stop Started")
//    }
    }

//@Composable
//fun TextStyledBrushSnippet() {
//    val rainbowColors: List<Color> = listOf()
//    // [START android_compose_text_annotatedString_brush]
//    Text(
//        text = buildAnnotatedString {
//            append("Do not allow people to dim your shine\n")
//            withStyle(
//                SpanStyle(
//                    brush = Brush.linearGradient(
//                        colors = rainbowColors
//                    )
//                )
//            ) {
//                append("because they are blinded.")
//            }
//            append("\nTell them to put some sunglasses on.")
//        }
//    )
//    // [END android_compose_text_annotatedString_brush]
//}

    @Composable
    fun MultipleStylesInText() {
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Blue)) {
                    append("H")
                }
                append("ello ")

                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Red)) {
                    append("W")
                }
                append("orld")
            }
        )
    }

    @Composable
    fun TextStyledBrushSnippet(text: String) {
        val lightBlue = Color(0xFF0066FF)
        val purple = Color(0xFF800080)
        val gradientColors = listOf(Color.Cyan, lightBlue, purple)

        Text(
            text = text,
            style = TextStyle(
                brush = Brush.linearGradient(
                    colors = gradientColors
                )
            )
        )
    }

