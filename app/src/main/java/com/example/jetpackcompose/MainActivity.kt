package com.example.jetpackcompose


import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeTheme {
                Column(
                    modifier = Modifier
                        .padding(20.dp)
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Row {
                        //Filled button
                        Button(
                            onClick = { println("Button is Clicked") }, //1
//                        shape = RectangleShape,
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(Color.Red),
                            modifier = Modifier
                                .size(width = 200.dp, height = 50.dp)
                        ) {
                            Text(text = "Add to Cart", color = Color.White)
                            Icon(
                                Icons.Rounded.ShoppingCart,
                                contentDescription = "Shopping"
                            )
                        }

                        //Text button
                        TextButton(onClick = {
                            println("Button is Clicked") //3
                        }) {
                            Text("Add to Cart")
                        }
                    }
                    Row {
                        //Filled tonal button
                        FilledTonalButton(onClick = {
                            println("Button is Clicked") //2
                        }) {
                            Text(text = "Add to Cart")
                        }
                        //Outlined button
                        OutlinedButton(onClick = {
                            println("Button is Clicked") //3
                        }) {
                            Text(text = "Add to Cart")
                        }
                        //Elevated button
                        ElevatedButton(onClick = {
                            println("Button is Clicked") //3
                        }) {
                            Text(text = "Add to Cart")
                        }
                    }
                    Row {
                        //Floating button
                        FloatingActionButton(
                            onClick = {}, //4
                            containerColor = colorResource(id = R.color.newcolor),
                            contentColor = Color.Green
                        ) {
                            Icon(
                                Icons.Default.Add,
                                contentDescription = "Add"
                            )
                        }
                        //Floating action button
                        FloatingActionButton(
                            onClick = { },
                        ) {
                            Icon(Icons.Filled.Add, "Floating action button.")
                        }
                        //Small button
                        SmallFloatingActionButton(
                            onClick = { },
                            containerColor = MaterialTheme.colorScheme.secondaryContainer,
                            contentColor = MaterialTheme.colorScheme.secondary
                        ) {
                            Icon(Icons.Filled.Add, "Small floating action button.")
                        }
                        //Large button
                        LargeFloatingActionButton(
                            onClick = { },
                            shape = CircleShape,
                        ) {
                            Icon(Icons.Filled.Add, "Large floating action button")
                        }
                        //Extended button
                        ExtendedFloatingActionButton(
                            onClick = { },
                            icon = { Icon(Icons.Filled.Edit, "Extended floating action button.") },
                            text = { Text(text = "FAB") },
                        )

                    }
                    Row {
                        //Card
                        Card(
                            colors = CardDefaults.cardColors(
                                containerColor = Color.Red,
                                contentColor = Color.Green
                            ),
                            modifier = Modifier
                                .size(width = 80.dp, height = 80.dp)
                        ) {
                            Text(text = "Filled Card",
                                modifier = Modifier
                                    .padding(16.dp),
                                textAlign = TextAlign.Center,)
                        }
                        //Filled card
                        Card(
                            colors = CardDefaults.cardColors(
                                containerColor = MaterialTheme.colorScheme.surfaceVariant,
                            ),
                            modifier = Modifier
                                .size(width = 75.dp, height = 100.dp)
                        ) {
                            Text(
                                text = "Filled",
                                modifier = Modifier
                                    .padding(15.dp),
                                textAlign = TextAlign.Center,
                            )
                        }
                        //Elevated Card
                        ElevatedCard(
                            elevation = CardDefaults.cardElevation(
                                defaultElevation = 6.dp
                            ),
                            modifier = Modifier
                                .size(width = 95.dp, height = 100.dp)
                        ) {
                            Text(
                                text = "Elevated",
                                modifier = Modifier
                                    .padding(15.dp),
                                textAlign = TextAlign.Center,
                            )
                        }
                        //Suggestion chip
                        SuggestionChip(
                            onClick = { Log.d("Suggestion chip", "hello world") },
                            label = { Text("Suggestion chip") }
                        )
                    }
                    Row {
                        //Assist chip
                        AssistChip(
                            onClick = { Log.d("Assist chip", "hello world") },
                            label = { Text("Assist chip") },
                            leadingIcon = {
                                Icon(
                                    Icons.Filled.Settings,
                                    contentDescription = "Localized description",
                                    Modifier.size(AssistChipDefaults.IconSize)
                                )
                            }
                        )
                        //Filter chip
                        var selected by remember { mutableStateOf(false) }
                        FilterChip(
                            onClick = { selected = !selected },
                            label = {
                                Text("Filter chip")
                            },
                            selected = selected,
                            leadingIcon = if (selected) {
                                {
                                    Icon(
                                        imageVector = Icons.Filled.Done,
                                        contentDescription = "Done icon",
                                        modifier = Modifier.size(FilterChipDefaults.IconSize)
                                    )
                                }
                            } else {
                                null
                            },
                        )
                        //Input chip
                        InputChipExample("Tanushree ")

                    }
                    //Slider
                    var value by remember { mutableFloatStateOf(0f) }
                    Slider(
                        value = value,
                        onValueChange = { value = it }
                    )
                    Text(text = value.toString())
                    //Range slider
                    var sliderPosition by remember { mutableStateOf(0f..100f) }
                    Column {
                        RangeSlider(
                            value = sliderPosition,
                            steps = 5,
                            onValueChange = { range -> sliderPosition = range },
                            valueRange = 0f..100f,
                            onValueChangeFinished = {
                                // launch some business logic update with the state you hold
                                // viewModel.updateSelectedSliderValue(sliderPosition)
                            },
                        )
                        Text(text = sliderPosition.toString())
                    }
                    Row {
                        //Switch
                        var checked by remember { mutableStateOf(true) }
                        Switch(
                            checked = checked,
                            onCheckedChange = {
                                checked = it
                            }
                        )
                        Text(text = checked.toString(),textAlign = TextAlign.Center,)
                        //Custom thumb & colors Switch
                        var checked2 by remember { mutableStateOf(true) }

                        Switch(
                            checked = checked2,
                            onCheckedChange = {
                                checked2 = it
                            },
                            //colors
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = MaterialTheme.colorScheme.primary,
                                checkedTrackColor = MaterialTheme.colorScheme.primaryContainer,
                                uncheckedThumbColor = MaterialTheme.colorScheme.secondary,
                                uncheckedTrackColor = MaterialTheme.colorScheme.secondaryContainer,
                            ),
                            //thumb
                            thumbContent = if (checked2) {
                                {
                                    Icon(
                                        imageVector = Icons.Filled.Check,
                                        contentDescription = null,
                                        modifier = Modifier.size(SwitchDefaults.IconSize),
                                    )
                                }
                            } else {
                                null
                            }
                        )

                    }
                    //Horizontal divider
                    Column(
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                    ) {
                        Text("First item in list")
                        HorizontalDivider(thickness = 2.dp)
                        Text("Second item in list")
                    }
                    //Vertical divider
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(IntrinsicSize.Min),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Text("First item in row")
                        VerticalDivider(color = MaterialTheme.colorScheme.secondary)
                        Text("Second item in row")
                    }
                    //Determinate indicators
                    LinearDeterminateIndicator()
                    //Indeterminate indicators
                    IndeterminateCircularIndicator()
                    Row {
                        //Checkbox
                        CheckboxMinimalExample()
                        //Images
                        Image(
                            painter = painterResource(id = R.drawable.image),
                            contentDescription = ""
                        )
                    }

                }
            }
        }
    }
}

@Composable
fun InputChipExample(
    text: String,
//    onDismiss: () -> Unit,
) {
    var enabled by remember { mutableStateOf(true) }
    if (!enabled) return

    InputChip(
        onClick = {
//            onDismiss()
            enabled = !enabled
        },
        label = { Text(text) },
        selected = enabled,
        avatar = {
            Icon(
                Icons.Filled.Person,
                contentDescription = "Localized description",
                Modifier.size(InputChipDefaults.AvatarSize)
            )
        },
        trailingIcon = {
            Icon(
                Icons.Default.Close,
                contentDescription = "Localized description",
                Modifier.size(InputChipDefaults.AvatarSize)
            )
        },
    )
}
//Determinate indicators
@Composable
fun LinearDeterminateIndicator() {
    var currentProgress by remember { mutableFloatStateOf(0f) }
    var loading by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope() // Create a coroutine scope

    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(onClick = {
            loading = true
            scope.launch {
                loadProgress { progress ->
                    currentProgress = progress
                }
                loading = false // Reset loading when the coroutine finishes
            }
        }, enabled = !loading) {
            Text("Start loading")
        }

        if (loading) {
            LinearProgressIndicator(
                progress = { currentProgress },
                modifier = Modifier.fillMaxWidth(),
            )
        }
    }
}

/** Iterate the progress value */
suspend fun loadProgress(updateProgress: (Float) -> Unit) {
    for (i in 1..100) {
        updateProgress(i.toFloat() / 100)
        delay(100)
    }
}
//Indeterminate indicators
@Composable
fun IndeterminateCircularIndicator() {
    var loading by remember { mutableStateOf(false) }

    Button(onClick = { loading = true }, enabled = !loading) {
        Text("Start loading")
    }

    if (!loading) return

    CircularProgressIndicator(
        modifier = Modifier.width(64.dp),
        color = MaterialTheme.colorScheme.secondary,
        trackColor = MaterialTheme.colorScheme.surfaceVariant,
    )
}
//Checkout
@Composable
fun CheckboxMinimalExample() {
    var checked by remember { mutableStateOf(true) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            "Minimal checkbox"
        )
        Checkbox(
            checked = checked,
            onCheckedChange = { checked = it }
        )
    }

//    Text(
//        if (checked) "Checkbox is checked" else "Checkbox is unchecked"
//    )
}