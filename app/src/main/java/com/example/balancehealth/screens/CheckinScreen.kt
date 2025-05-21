package com.example.balancehealth.screens

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.balancehealth.data.AppDatabase
import com.example.balancehealth.data.AutoAvaliacao
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckinScreen(
    navController: NavController,
    context: Context = LocalContext.current
) {
    val scope = rememberCoroutineScope()
    val database = remember { AppDatabase.getDatabase(context) }
    var showDialog by remember { mutableStateOf(false) }
    var ultimaAvaliacao by remember { mutableStateOf<AutoAvaliacao?>(null) }
    val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale("pt", "BR"))

    LaunchedEffect(Unit) {
        scope.launch {
            ultimaAvaliacao = database.autoAvaliacaoDao().obterUltimaAvaliacao()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Check-in",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        ultimaAvaliacao?.let { avaliacao ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Última Autoavaliação",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = "Data: ${dateFormat.format(avaliacao.data)}",
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    // Índices calculados
                    Column(modifier = Modifier.fillMaxWidth()) {
                        ItemAvaliacao(
                            titulo = "Índice de Relacionamento",
                            valor = "%.2f".format(avaliacao.indiceRelacionamento)
                        )
                        ItemAvaliacao(
                            titulo = "Índice de Comunicação",
                            valor = "%.2f".format(avaliacao.indiceComunicacao)
                        )
                        ItemAvaliacao(
                            titulo = "Índice de Relação com Liderança",
                            valor = "%.2f".format(avaliacao.indiceRelacaoLideranca)
                        )
                        ItemAvaliacao(
                            titulo = "Índice de Burnout",
                            valor = "%.2f".format(avaliacao.indiceBurnout),
                            cor = when {
                                avaliacao.indiceBurnout >= 4.0 -> Color.Red
                                avaliacao.indiceBurnout >= 3.0 -> Color(0xFFFFA500)
                                else -> Color.Green
                            }
                        )
                        ItemAvaliacao(
                            titulo = "Classificação de Risco",
                            valor = avaliacao.classificacaoRisco,
                            cor = when (avaliacao.classificacaoRisco) {
                                "Alto Risco" -> Color.Red
                                "Médio Risco" -> Color(0xFFFFA500)
                                else -> Color.Green
                            }
                        )
                    }
                }
            }
        }

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

@Composable
private fun ItemAvaliacao(
    titulo: String,
    valor: String,
    cor: Color = Color.Unspecified
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = titulo)
        Text(text = valor, color = cor)
    }
}
