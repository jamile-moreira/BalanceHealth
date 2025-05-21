package com.example.balancehealth.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.balancehealth.R

@OptIn(ExperimentalMaterial3Api::class)
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
            verticalArrangement = Arrangement.Center
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
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = senha,
                onValueChange = { senha = it },
                singleLine = true,
                label = { Text(text = "Senha") },
                placeholder = { Text(text = "Digite aqui sua senha") },
                shape = RoundedCornerShape(topStart = 32.dp, bottomEnd = 32.dp),
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Esqueceu a senha?", color = Color.Gray)
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "Não tem cadastro?", color = Color(0xFF781193), fontSize = 18.sp)
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "Cadastre-se aqui", color = Color.Blue, fontSize = 16.sp)
            }
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = { navController.navigate("home") },
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(bottom = 10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF97589F)
                ),
            ) {
                Text("Login", fontSize = 23.sp)
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun LoginScreenPreview() {
//    LoginScreen(navController = object : NavController(null) {})
//}
