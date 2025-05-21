package com.example.balancehealth.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun RecursosApoioScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Título principal
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(2.dp, Color(0xFF90CAF9), RoundedCornerShape(8.dp))
                .padding(vertical = 16.dp)
        ) {
            Text(
                text = "Recursos de Apoio",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Frase motivacional do dia
        Box(
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .border(2.dp, Color(0xFF90CAF9), RoundedCornerShape(8.dp))
                .padding(vertical = 18.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = "Frase motivacional\ndo dia",
                fontSize = 18.sp,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

        // Caixa de recursos de apoio
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .border(2.dp, Color(0xFF90CAF9), RoundedCornerShape(12.dp))
                .padding(24.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = "RECURSOS\nde APOIO",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(24.dp))
                // Linhas representando os recursos
                repeat(5) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(4.dp)
                            .background(Color(0xFF90CAF9))
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }

        // Botão para voltar para Home
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = { navController.navigate("home") },
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text("Voltar para Home", fontSize = 16.sp, color = Color.White)
        }
    }
}

// Preview para RecursosApoioScreen
//@Preview(showBackground = true)
//@Composable
//fun RecursosApoioScreenPreview() {
//    RecursosApoioScreen(navController = object : NavController(null) {})
//}
