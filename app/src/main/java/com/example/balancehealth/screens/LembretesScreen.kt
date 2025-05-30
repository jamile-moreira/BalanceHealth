package com.example.balancehealth.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.graphics.Shape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.navigation.NavController
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LembretesScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(24.dp)
    ) {
        Text(
            text = "Lembretes",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // Primeira linha: Lembrete 1 e Lembrete 2
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(100.dp)
                    .border(2.dp, Color(0xFF90CAF9))
                    .padding(8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text("Lembrete 1", fontSize = 18.sp, fontWeight = FontWeight.Medium)
            }
            Box(
                modifier = Modifier
                    .width(100.dp)
                    .height(140.dp)
                    .border(2.dp, Color(0xFF90CAF9))
                    .padding(8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text("Lembrete 2", fontSize = 18.sp, fontWeight = FontWeight.Medium)
            }
        }

        // Lembrete 3
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .border(2.dp, Color(0xFF90CAF9))
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text("Lembrete 3", fontSize = 18.sp, fontWeight = FontWeight.Medium)
        }

        Spacer(modifier = Modifier.height(24.dp))
        // Botão para voltar para Home
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

// Preview para LembretesScreen
//@Preview(showBackground = true)
//@Composable
//fun LembretesScreenPreview() {
//    LembretesScreen(navController = object : NavController(null) {})
//}
