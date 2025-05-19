package com.example.balancehealth.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.balancehealth.R

@Composable
fun LoginScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color.White, Color(0xFFF4FFE3))
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(40.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,

        ) {
            Image(
                modifier = Modifier
                    .size(128.dp)
                    .padding(top = 20.dp),
                painter = painterResource(R.drawable.logo),
                contentDescription = "Logo"
            )
            Spacer(modifier = Modifier.height(150.dp))
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                singleLine = true,
                label = { Text(text = "E-mail") },
                placeholder = { Text(text = "Digite aqui seu e-mail") },
                shape = RoundedCornerShape(topStart = 32.dp, bottomEnd = 32.dp),
                colors = OutlinedTextFieldDefaults.colors(unfocusedTextColor = Color.Green),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = senha,
                onValueChange = { senha = it },
                singleLine = true,
                label = { Text(text = "Senha") },
                placeholder = { Text(text = "Digite aqui sua senha") },
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.password_24),
                        contentDescription = "Ícone person"
                    )
                },
                shape = RoundedCornerShape(topStart = 32.dp, bottomEnd = 32.dp),
                colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = Color.Green),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "Esqueceu a senha?", color = Color.Gray)

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "Não tem cadastro?", color = Color.Green, fontSize = 18.sp)
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "Cadastre-se aqui", color = Color.Blue, fontSize = 16.sp)
            }

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    navController.navigate("home")
                },
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
                    .padding(bottom = 30.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF717A46)
                ),
            ) {
                Text("Login", fontSize = 23.sp)

            }
        }
    }
}

//@Preview()
//@Composable
//fun LoginScreenPreview(){
//    LoginScreen()
//}