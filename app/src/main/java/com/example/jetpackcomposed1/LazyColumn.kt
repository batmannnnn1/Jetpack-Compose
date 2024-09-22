package com.example.jetpackcomposed1

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// data class for the Category Objects..
data class Category(val img:Int,val title:String,val subtitle:String)

// this methods give the list...
fun getCategory():MutableList<Category>{
    val list = mutableListOf(
        Category(R.drawable.pfp_image,"Programmer","Ayann"),
        Category(R.drawable.pfp_image,"Programmer","Ayann"),
        Category(R.drawable.pfp_image,"Programmer","Ayann"),
        Category(R.drawable.pfp_image,"Programmer","Ayann"),
        Category(R.drawable.pfp_image,"Programmer","Ayann"),
        Category(R.drawable.pfp_image,"Programmer","Ayann"),
        Category(R.drawable.pfp_image,"Programmer","Ayann"),
        Category(R.drawable.pfp_image,"Programmer","Ayann"),
        Category(R.drawable.pfp_image,"Programmer","Ayann"),
        Category(R.drawable.pfp_image,"Programmer","Ayann"),
        Category(R.drawable.pfp_image,"Programmer","Ayann"),
        Category(R.drawable.pfp_image,"Programmer","Ayann"))

     return list
}

// Calling the composable for title and subtitle and creating the composable for image...
@Composable
fun GetLayoutInfo(image:Int,title: String,subtitle: String) {
    Card( modifier = Modifier.padding(8.dp)) {


        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(8.dp)) {
            Image(
                painter = painterResource(id = R.drawable.pfp_image),
                contentDescription = "ProfilePicture",
                modifier = Modifier
                    .size(48.dp)
                    .padding(8.dp)
                    .weight(.2f)
            )

            ItemDescription(title = title, subtitle = subtitle, modifier = Modifier.weight(.8f))
        }

    
    }
}

// composable for title and subtitle
@Composable
fun ItemDescription(title: String,subtitle: String,modifier: Modifier){
    Column(modifier = modifier) {
        Text(text = title, style = MaterialTheme.typography.headlineMedium)
        Text(text = subtitle, style = MaterialTheme.typography.labelSmall, fontWeight = FontWeight.Thin)

    }
}

@Preview(heightDp = 500, showSystemUi = true)
@Composable
fun PreviewItem(){

    LazyColumn(content =  {
        items(getCategory()){
            item -> GetLayoutInfo(image = item.img, title = item.title, subtitle = item.subtitle)
        }
    })
}
