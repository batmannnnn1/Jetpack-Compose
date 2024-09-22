package com.example.jetpackcomposed1

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showSystemUi = true)
@Composable
fun NotificationScreen(){
    /* State hosting means that the state is defined at a higher level (in NotificationScreen),
     and this state is passed down to child composable (NotificationCounter and MessageBar).

*/
    val state = rememberSaveable { mutableIntStateOf(0) }
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(1f)) {



        NotificationCounter(state.intValue) { state.intValue++ }
        MessageBar(count = state.intValue)
    }
}





@Composable
fun NotificationCounter(count:Int,increment:()->Unit){

    Column {
       Text(text = "the value is $count")
       Button(onClick = {increment()}) {
           Log.d("TAG","OnClicked...")
       }
    }
}

@Composable
fun MessageBar(count: Int){
    Card(elevation = CardDefaults.cardElevation(4.dp)) {

        Row(modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically) {

          Image(imageVector = Icons.Outlined.Favorite,
              contentDescription = "",
              modifier = Modifier.padding(4.dp))
        
            
            Text(text = "Message sent so far - $count")
        }
    }
}

/*
Unidirectional Data Flow:

In unidirectional data flow, data flows in one direction: from parent to child, and events flow from child to parent. Here's how it applies in your code:

It's a way of managing how data moves through your app. Data flows in one direction only: from the top (parent) to the bottom (children). If something changes (like clicking a button)
, the change goes back up to the parent, and the updated data flows down again.

The state (state.intValue) is passed downward to both NotificationCounter and MessageBar. These child composables display the current count based on this state.
The NotificationCounter composable accepts a function increment as a parameter, (which is passed down from the parent) This function updates the state when the button is clicked.
The state change is triggered in NotificationCounter, but the actual state is updated in NotificationScreen. The updated state then flows back down to the children.


(which is passed down from the Parent ) -> Parent composable defines the increment Function and the child composable just accept this function...
so the state updates in the parent composable and then parent send the data to the child composable 

State flows downward: state.intValue is passed to both NotificationCounter (to display the current count) and MessageBar (to display the message count).
Events flow upward: When the button in NotificationCounter is clicked, it calls the increment function, which modifies the state.intValue in the parent composable (NotificationScreen).




Why Unidirectional Data Flow?

Simplifies state management: Since the state is managed in one place (NotificationScreen), it's easier to track where state changes happen.
Predictable updates: The state is updated in the parent (NotificationScreen), and the child composables (NotificationCounter and MessageBar) simply reflect the current state. This makes the data flow predictable and reduces bugs.
Recomposition efficiency: When the state changes, Jetpack Compose knows exactly which parts of the UI need to be updated (the parts that depend on state.intValue).






 */