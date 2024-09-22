package com.example.jetpackcomposed1

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            }
        }
    }


@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!"
    )
}


@Composable
fun Title(){
val state = remember {mutableStateOf("")} // we use the remember function to stored the last state..cause we now composable function calls the many time with the different value...
    TextField(
        value = "Hello Ayan"
        , onValueChange =  {
            state.value = it
        },
        label = { Text(text = "Enter Message")})

}

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    Greeting(name = "Hello World!" )
}

//@Preview(showSystemUi = true, showBackground = true)
@Composable
fun TitlePreview(){
  Title()
}

@Preview(showSystemUi = true, widthDp = 393, heightDp = 500)
@Composable
fun ShowColumn(){
    Column(verticalArrangement = Arrangement.SpaceEvenly) {
        Text("Stay Away!", fontSize = 24.sp)
        Text(text = "not like us", fontSize = 24.sp)
    }
}

@Preview(showSystemUi = true, widthDp = 393, heightDp = 500)
@Composable
fun ShowRow(){
    Row(horizontalArrangement = Arrangement.SpaceBetween
    , verticalAlignment = Alignment.CenterVertically) {
        Text(text = "Never Back Down!", fontSize = 20.sp)
        Text(text = "Never Back Down!", fontSize = 20.sp)
    }
}

/*

1. Arrangement (horizontalArrangement, verticalArrangement)

What it does: Controls how child elements are spaced or distributed along the main axis of a layout (either horizontally in a Row or vertically in a Column).
Main Focus: Spacing and distribution of items.

Example:
In a Row (horizontalArrangement): Controls how children are arranged horizontally.
In a Column (verticalArrangement): Controls how children are arranged vertically.

Key types of Arrangement:

Arrangement.SpaceBetween: Places the first and last child at the edges, and distributes the space evenly between the remaining children.
Arrangement.Center: Places all children in the center of the main axis.

In short: Arrangement is about spacing and distribution along the main axis of a layout (horizontal for Row, vertical for Column).

2. Alignment (horizontalAlignment, verticalAlignment)

What it does: Controls how child elements are positioned relative to the cross axis of a layout (the opposite axis from the arrangement).
Main Focus: Alignment of items on the cross axis (for example, aligning elements in the vertical center of a row).

Example:
In a Row (verticalAlignment): Controls how children are aligned vertically.
In a Column (horizontalAlignment): Controls how children are aligned horizontally.

Key types of Alignment:

Alignment.CenterVertically: Aligns all the children in the vertical center of a Row.
Alignment.Start: Aligns children to the start of the cross axis (top in Column or left in Row).

In short: Alignment is about positioning items on the cross axis of a layout (vertical for Row, horizontal for Column).


 */







