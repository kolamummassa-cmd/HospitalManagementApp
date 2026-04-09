package com.example.hospitalmanagementsystem.ui.theme.screens.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.navigationevent.compose.rememberNavigationEventDispatcherOwner
import com.example.hospitalmanagementsystem.data.AuthViewModel
import com.example.hospitalmanagementsystem.navigation.ROUTE_LOGIN
import com.example.hospitalmanagementsystem.navigation.ROUTE_REGISTER

@Composable
fun LoginScren(navController: NavController){
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val authViewModel: AuthViewModel = viewModel()
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Log In",
            color = Color.Green,
            fontSize = 33.sp,
            fontWeight = FontWeight.Bold
        )
        OutlinedTextField(
            value = email,
            onValueChange = {email = it},
            label = { Text(text = "Enter Email")},
            placeholder = {Text(text = "Please Enter Email")},
            leadingIcon = {Icon(Icons.Default.Email,contentDescription = null)}
        )
        OutlinedTextField(
            value = password,
            onValueChange = {password = it},
            label = { Text(text = "Enter Password")},
            placeholder = {Text(text = "Please Enter Password")},
            leadingIcon = { Icon(Icons.Default.Lock,contentDescription = null) }

        )
        Button(onClick = {authViewModel.login(
            email = email,
            password = password,
            navController = navController,
            context = context)}) { Text(
            text = "Login"
        )}
        Row {
            Text(text = "You've not registered?",
                color = Color.Red)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Sign Up",
                color = Color.Blue,
                modifier = Modifier.clickable{ navController.navigate(ROUTE_REGISTER)})
        }

    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview(){
    LoginScren(rememberNavController())
}