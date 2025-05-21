package com.example.balancehealth.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun CheckinScreen(navController: NavController) {
    var showDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Outros elementos da tela de check-in aqui...

        Button(
            onClick = { showDialog = true },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ir para Autoavaliação")
        }

        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text("Atenção") },
                text = {
                    Text("Você será direcionado ao formulário de autoavaliação, é imprescindível que a sua resposta seja sincera e o mais fiel possível aos seus sentimentos em relação ao ambiente e a si. Os dados são anonimizados, este é um local seguro!")
                },
                confirmButton = {
                    Button(onClick = {
                        showDialog = false
                        navController.navigate("autoavaliacao")
                    }) {
                        Text("Continuar")
                    }
                },
                dismissButton = {
                    Button(onClick = { showDialog = false }) {
                        Text("Cancelar")
                    }
                }
            )
        }
    }
}