package com.example.task4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.res.TypedArrayUtils.getResourceId
import com.example.task4.ui.theme.Task4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Task4Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

val cityName = listOf("Islamabad", "Karachi", "Moscow", "Mumbai", "New York", "Paris")


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val imageName = listOf(
        painterResource(id = R.drawable.islamabad),
        painterResource(id = R.drawable.karachi),
        painterResource(id = R.drawable.moscow),
        painterResource(id = R.drawable.mumbai),
        painterResource(id = R.drawable.newyork),
        painterResource(id = R.drawable.paris)
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Lazy Grid layout") },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Blue,
                    titleContentColor = (Color.White))
                )
        }
    ){it->LazyVerticalGrid(
        modifier = Modifier
            .fillMaxSize()
            .padding(it),
        columns = GridCells.Fixed(2),
        content = {
            items(imageName.size) { index ->
                val image = imageName[index]
                val city = cityName[index]
                ImageText(image, city)
            }
        }
    )

    }
}

@Composable
fun ImageText(image: Painter, city: String) {
    Column {
        Image(modifier = Modifier
            .padding(6.dp)
            .size(150.dp),
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Fit
        )
        Text(modifier = Modifier
            .background(Color.Blue)
            .width(150.dp)
            .height(25.dp),
            color = Color.White
            , text = city,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold)
    }
}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Task4Theme {
        Greeting("Android")
    }
}