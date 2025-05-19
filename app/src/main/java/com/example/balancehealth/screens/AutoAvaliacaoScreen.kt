package com.example.balancehealth.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun AutoAvaliacaoScreen(navController: NavController) {
    var selectedOption by remember { mutableStateOf("Baixo") }
    var resposta by remember { mutableStateOf("") }
    val opcoes = listOf("Baixo", "Normal", "Alto", "Muito alto")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "AUTO AVALIAÇÃO",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 24.dp)
        )
        Text(
            text = "Como foi seu desempenho dessa semana?",
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        // Lista de opções
        opcoes.forEach { opcao ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                RadioButton(
                    selected = selectedOption == opcao,
                    onClick = { selectedOption = opcao }
                )
                Text(
                    text = opcao,
                    fontSize = 16.sp,
                    fontWeight = if (selectedOption == opcao) FontWeight.Bold else FontWeight.Normal
                )
            }
        }
        Spacer(modifier = Modifier.height(32.dp))
        // Espaço para resposta (simulando linhas)
        TextField(
            value = resposta,
            onValueChange = { resposta = it },
            placeholder = { Text("Escreva aqui suas observações...") },
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color(0xFFF5F5F5),
                focusedIndicatorColor = Color(0xFF90CAF9),
                unfocusedIndicatorColor = Color(0xFF90CAF9)
            )
        )
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = { /* ação do botão */ },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(top = 24.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF90CAF9)
            )
        ) {
            Text("Para desenvolver", fontSize = 18.sp, color = Color.White)
        }
    }
}