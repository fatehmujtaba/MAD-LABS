package com.example.task3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.task3.ui.theme.Task3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Task3Theme {
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

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
Column (modifier= Modifier
    .fillMaxWidth()
    .padding(5.dp),
    ){
      Row {
          Image(painter = painterResource(id = R.drawable.shanks),
              contentDescription = null,
              contentScale = ContentScale.Fit,
              modifier=Modifier.size(80.dp)
          )
          Column {
              Text(text = "Red Hair Shanks",
                  fontWeight = FontWeight.Bold,
                  fontFamily= FontFamily.Serif,
                  fontSize = 20.sp)
              Text(text = "Age: 43",
                  fontWeight = FontWeight.Light,
                  fontFamily= FontFamily.Serif,
                  fontSize = 15.sp)
      }
        }

    Row {
        Image(painter = painterResource(id = R.drawable.batman),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier=Modifier.size(80.dp).padding(10.dp)
        )
        Column {
            Text(text = "Batman",
                fontWeight = FontWeight.Bold,
                fontFamily= FontFamily.Serif,
                fontSize = 20.sp)
            Text(text = "Age: 35",
                fontWeight = FontWeight.Light,
                fontFamily= FontFamily.Serif,
                fontSize = 15.sp)
        }
    }

    Row {
        Image(painter = painterResource(id = R.drawable.goku),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier=Modifier.size(100.dp)
        )
        Column {
            Text(text = "Goku (Kakarot)",
                fontWeight = FontWeight.Bold,
                fontFamily= FontFamily.Serif,
                fontSize = 20.sp)
            Text(text = "Age: 38",
                fontWeight = FontWeight.Light,
                fontFamily= FontFamily.Serif,
                fontSize = 15.sp)
        }
    }

    Row {
        Image(painter = painterResource(id = R.drawable.yami),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier=Modifier.size(80.dp)
        )
        Column {
            Text(text = "yami sukehiro",
                fontWeight = FontWeight.Bold,
                fontFamily= FontFamily.Serif,
                fontSize = 20.sp)
            Text(text = "Age: 32",
                fontWeight = FontWeight.Light,
                fontFamily= FontFamily.Serif,
                fontSize = 15.sp)
        }


    }

    Row {
        Image(painter = painterResource(id = R.drawable.hulk),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier=Modifier.size(80.dp)
        )
        Column {
            Text(text = "Hulk",
                fontWeight = FontWeight.Bold,
                fontFamily= FontFamily.Serif,
                fontSize = 20.sp)
            Text(text = "Age: 39",
                fontWeight = FontWeight.Light,
                fontFamily= FontFamily.Serif,
                fontSize = 15.sp)
        }
    }

}
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Task3Theme {
        Greeting("Android")
    }
}