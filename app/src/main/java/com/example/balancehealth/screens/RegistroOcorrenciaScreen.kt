package com.example.balancehealth.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistroOcorrenciaScreen(navController: NavController) {
    var text by remember { mutableStateOf("") }
    var expandedSimNao by remember { mutableStateOf(false) }
    var selectedOptionSimNao by remember { mutableStateOf("Selecione uma opção") }
    val optionsSimNao = listOf("Sim", "Não")

    var expandedCarater by remember { mutableStateOf(false) }
    var selectedOptionCarater by remember { mutableStateOf("Selecione o caráter") }
    val optionsCarater = listOf("Normal", "Urgência", "Emergência")

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color.White, Color(0x97D0F2FF))
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 50.dp, start = 25.dp, end = 25.dp)
        ) {
            Text(
                "Nos conte onde foi a ocorrência",
                fontSize = 22.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF005E94)
            )
            Spacer(modifier = Modifier.height(25.dp))
            TextField(
                value = text,
                onValueChange = { newText -> text = newText },
                placeholder = { Text("Digite aqui o endereço da ocorrência") },
                modifier = Modifier.fillMaxWidth(),
                textStyle = androidx.compose.ui.text.TextStyle(
                    fontSize = 22.sp
                ),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color(0x809BDBFC),
                    focusedIndicatorColor = Color.Blue,
                    unfocusedIndicatorColor = Color.Gray
                )
            )
            Spacer(modifier = Modifier.height(25.dp))
            Text(
                "Acionou alguma autoridade pública?",
                fontSize = 22.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF005E94)
            )
            Spacer(modifier = Modifier.height(25.dp))
            ExposedDropdownMenuBox(
                expanded = expandedSimNao,
                onExpandedChange = { expandedSimNao = !expandedSimNao }
            ) {
                TextField(
                    value = selectedOptionSimNao,
                    onValueChange = {},
                    readOnly = true,
                    label = { Text("Escolha uma opção") },
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedSimNao)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .menuAnchor(),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color(0x809BDBFC),
                        focusedIndicatorColor = Color.Blue,
                        unfocusedIndicatorColor = Color.Gray
                    ),
                    textStyle = androidx.compose.ui.text.TextStyle(
                        fontSize = 22.sp
                    )
                )
                DropdownMenu(
                    expanded = expandedSimNao,
                    onDismissRequest = { expandedSimNao = false }
                ) {
                    optionsSimNao.forEach { option ->
                        DropdownMenuItem(
                            text = { Text(option) },
                            onClick = {
                                selectedOptionSimNao = option
                                expandedSimNao = false
                            }
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(25.dp))
            Text(
                "Caráter da ocorrência",
                fontSize = 22.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF005E94)
            )
            Spacer(modifier = Modifier.height(25.dp))
            ExposedDropdownMenuBox(
                expanded = expandedCarater,
                onExpandedChange = { expandedCarater = !expandedCarater }
            ) {
                TextField(
                    value = selectedOptionCarater,
                    onValueChange = {},
                    readOnly = true,
                    label = { Text("Escolha o caráter") },
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedCarater)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .menuAnchor(),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color(0x809BDBFC),
                        focusedIndicatorColor = Color.Blue,
                        unfocusedIndicatorColor = Color.Gray
                    ),
                    textStyle = androidx.compose.ui.text.TextStyle(
                        fontSize = 22.sp
                    )
                )
                DropdownMenu(
                    expanded = expandedCarater,
                    onDismissRequest = { expandedCarater = false }
                ) {
                    optionsCarater.forEach { option ->
                        DropdownMenuItem(
                            text = { Text(option) },
                            onClick = {
                                selectedOptionCarater = option
                                expandedCarater = false
                            }
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(25.dp))
            Text(
                "Nos fale tudo que você viu com o máximo de detalhes",
                fontSize = 22.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF005E94)
            )
            Spacer(modifier = Modifier.height(25.dp))
            TextField(
                value = text,
                onValueChange = { newText -> text = newText },
                placeholder = { Text("Digite aqui os detalhes") },
                modifier = Modifier.fillMaxWidth(),
                textStyle = androidx.compose.ui.text.TextStyle(
                    fontSize = 22.sp
                ),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color(0x809BDBFC),
                    focusedIndicatorColor = Color.Blue,
                    unfocusedIndicatorColor = Color.Gray
                )
            )
            Spacer(modifier = Modifier.height(25.dp))

            Spacer(modifier = Modifier.weight(1f))
        }
        Button(
            onClick = {},
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(95.dp)
                .align(Alignment.BottomCenter)
                .padding(bottom = 25.dp, start = 16.dp, end = 16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF942B03)
            ),
        ) {
            Text("Registrar ocorrência", fontSize = 23.sp)
            Icon(
                imageVector = Icons.Default.Warning,
                contentDescription = "atencao",
            )
        }
    }
}

//@Preview
//@Composable
//fun RegistroOcorrenciaScreenPreview() {
//    RegistroOcorrenciaScreen()
//}
