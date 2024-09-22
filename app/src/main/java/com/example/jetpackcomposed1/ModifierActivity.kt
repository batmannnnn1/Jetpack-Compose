package com.example.jetpackcomposed1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class ModifierActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

        }
    }

   @Preview(showSystemUi = true, widthDp = 393, heightDp = 500)
    @Composable
    fun PreviewText(){
            Text(text = "HellWord",
                modifier = Modifier // execute one by one
                    .clickable { } // now clickable function applied full Composable
                    .background(Color.DarkGray)
                    .size(200.dp)
                    .border(4.dp, Color.Black)
                    .clip(CircleShape)
                    .background(Color.Yellow))

        }

     // use modifiers with accurate chaining methods..if you don't do that the behaviour of methods is changed...

    //@Preview(showSystemUi = true)
    @Composable
    fun Text(){

        Text(text = "Hello,World",
            modifier = Modifier
                .padding(16.dp)  // first padding
                .background(Color.Green)) // background color only applied in the padding area...
    }

}