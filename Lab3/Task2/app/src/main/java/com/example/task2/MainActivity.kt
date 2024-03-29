package com.example.task2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.task2.ui.theme.Task2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Task2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App() {
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = "register"){
        composable(route="login"){
            LoginScreen{
                navController.navigate("register")
            }
        }
        composable(route="register"){
            RegisterationScreen{
                navController.navigate("login")
            }
        }
    }

}

@Composable
fun RegisterationScreen (onClick:()->Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
            ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,

    )
 {
        var fullname by remember { mutableStateOf("") }

        TextField(modifier = Modifier.padding(15.dp),
            value = fullname, onValueChange ={fullname=it},
            label = { Text("Fullname") }
        )


     var email by remember { mutableStateOf("") }

     TextField(
         modifier = Modifier.padding(15.dp),
         value = email, onValueChange ={email=it},
         label = { Text("Email") }
     )
     var password by rememberSaveable { mutableStateOf("") }

     TextField(
         modifier = Modifier.padding(15.dp),
         value = password,
         onValueChange = { password = it },
         label = { Text("Enter password") },
         visualTransformation = PasswordVisualTransformation(),
         keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
     )

     Button(modifier = Modifier
         .padding(25.dp)
         .background(color = Color.Magenta)
         , onClick = {  }) {
         Text("Register")
     }
     Row(
         modifier = Modifier
             .fillMaxWidth()
             .padding(top = 16.dp),
         horizontalArrangement = Arrangement.Center
     ) {
         Text(
             text = "Already registered!",
             color = Color.White,
             fontSize = 14.sp
         )
         Text(
             modifier = Modifier.clickable { onClick() },
             text = " Login Me.",
             color = Color.Magenta,
             fontSize = 14.sp
         )

     }

    }


}

@Composable
fun LoginScreen(onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,

        ){

        var email by remember { mutableStateOf("") }

        TextField(
            modifier = Modifier.padding(15.dp),
            value = email, onValueChange ={email=it},
            label = { Text("Email") }
        )
        var password by rememberSaveable { mutableStateOf("") }

        TextField(
            modifier = Modifier.padding(15.dp),
            value = password,
            onValueChange = { password = it },
            label = { Text("Enter password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        Button(modifier = Modifier
            .padding(25.dp)
            .background(color = Color.Magenta)
            , onClick = {  }) {
            Text("Login")
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Not a member?",
                color = Color.White,
                fontSize = 14.sp
            )
            Text(modifier = Modifier.clickable { onClick() },
                text = " Sign up Now",
                color = Color.Magenta,
                fontSize = 14.sp
            )

        }

    }
}

