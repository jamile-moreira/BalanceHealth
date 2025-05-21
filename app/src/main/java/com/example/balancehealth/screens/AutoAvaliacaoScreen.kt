package com.example.balancehealth.screens

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.platform.LocalContext
import com.example.balancehealth.data.AutoAvaliacao
import com.example.balancehealth.data.AppDatabase
import kotlinx.coroutines.launch

private fun calcularIndices(respostas: List<String>): AutoAvaliacao {
    fun mapearResposta(resposta: String): Double = when(resposta) {
        "Sempre", "Ótimo", "Muito bem" -> 5.0
        "Frequentemente", "Bom", "Bem" -> 4.0
        "Às vezes", "Regular", "Normal" -> 3.0
        "Raramente", "Ruim", "Mal" -> 2.0
        "Nunca", "Péssimo", "Muito mal" -> 1.0
        else -> 0.0
    }

    val indiceRelacionamento = (7..13).map { mapearResposta(respostas[it]) }.average()
    val indiceComunicacao = (14..17).map { mapearResposta(respostas[it]) }.average()
    val indiceRelacaoLideranca = (18..22).map { mapearResposta(respostas[it]) }.average()

    // Cálculo do índice de burnout (baseado em carga de trabalho e sinais de alerta)
    val indiceBurnout = (2..6).map { 6 - mapearResposta(respostas[it]) }.average()

    val classificacaoRisco = when {
        indiceBurnout >= 4.0 -> "Alto Risco"
        indiceBurnout >= 3.0 -> "Médio Risco"
        else -> "Baixo Risco"
    }

    return AutoAvaliacao(
        sexo = respostas[0],
        sentimentoHoje = respostas[1],
        cargaTrabalho = respostas[2],
        impactoQualidadeVida = respostas[3],
        horasExtras = respostas[4],
        sintomasPsicologicos = respostas[5],
        impactoProdutividade = respostas[6],
        relacionamentoSetor = respostas[7],
        relacionamentoOutrosSetores = respostas[8],
        respeito = respostas[9],
        relacionamentoEquipe = respostas[10],
        liberdadeExpressao = respostas[11],
        valorizacao = respostas[12],
        cooperacao = respostas[13],
        feedbacks = respostas[14],
        comunicacaoAberta = respostas[15],
        circulacaoInformacoes = respostas[16],
        cienciaMetas = respostas[17],
        interesseLideranca = respostas[18],
        disponibilidadeLider = respostas[19],
        confortoReportarProblemas = respostas[20],
        reconhecimentoLider = respostas[21],
        confiancaLider = respostas[22],
        indiceRelacionamento = indiceRelacionamento,
        indiceComunicacao = indiceComunicacao,
        indiceRelacaoLideranca = indiceRelacaoLideranca,
        indiceBurnout = indiceBurnout,
        classificacaoRisco = classificacaoRisco
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AutoAvaliacaoScreen(
    navController: NavController,
    context: Context = LocalContext.current
) {
    val scope = rememberCoroutineScope()
    val database = remember { AppDatabase.getDatabase(context) }

    val perguntas = listOf(
        // Mapeamento de Risco
        Pair("Escolha o seu sexo (a) ou legal", listOf("Feminino", "Masculino", "Outro")),
        Pair("Como você se sente hoje?", listOf("Muito mal", "Mal", "Normal", "Bem", "Muito bem")),
        // Fatores de Carga de Trabalho
        Pair("Como você avalia sua carga de trabalho?", listOf("Muito alta", "Alta", "Média", "Baixa", "Muito baixa")),
        Pair("Sua carga de trabalho afeta sua qualidade de vida?", listOf("Sempre", "Frequentemente", "Às vezes", "Raramente", "Nunca")),
        Pair("Você trabalha além do seu horário regular?", listOf("Sempre", "Frequentemente", "Às vezes", "Raramente", "Nunca")),
        // Sinais de Alerta
        Pair("Você tem apresentado sintomas como insônia, irritabilidade, ansiedade ou tristeza?", listOf("Sempre", "Frequentemente", "Às vezes", "Raramente", "Nunca")),
        Pair("Você sente que sua saúde mental prejudica sua produtividade no trabalho?", listOf("Sempre", "Frequentemente", "Às vezes", "Raramente", "Nunca")),
        // Diagnóstico de Clima - Relacionamento
        Pair("Como avalia seu relacionamento com seus colegas de setor?", listOf("Ótimo", "Bom", "Regular", "Ruim", "Péssimo")),
        Pair("Como avalia seu relacionamento com seus colegas de outros setores?", listOf("Ótimo", "Bom", "Regular", "Ruim", "Péssimo")),
        Pair("Sinto que sou tratado(a) com respeito pelos meus colegas de trabalho.", listOf("Sempre", "Frequentemente", "Às vezes", "Raramente", "Nunca")),
        Pair("Consigo me relacionar de forma saudável e produtiva com minha equipe.", listOf("Sempre", "Frequentemente", "Às vezes", "Raramente", "Nunca")),
        Pair("Tenho liberdade para expressar opiniões e ideias nas reuniões e reuniões.", listOf("Sempre", "Frequentemente", "Às vezes", "Raramente", "Nunca")),
        Pair("Me sinto valorizado(a) pelos líderes e clima entre os colegas é saudável.", listOf("Sempre", "Frequentemente", "Às vezes", "Raramente", "Nunca")),
        Pair("Sinto que existe espírito de cooperação entre os colaboradores.", listOf("Sempre", "Frequentemente", "Às vezes", "Raramente", "Nunca")),
        // Comunicação
        Pair("Recebo feedbacks claros e efetivos sobre minha atuação e responsabilidades.", listOf("Sempre", "Frequentemente", "Às vezes", "Raramente", "Nunca")),
        Pair("Sinto que posso comunicar abertamente dúvidas e sugestões.", listOf("Sempre", "Frequentemente", "Às vezes", "Raramente", "Nunca")),
        Pair("As informações importantes circulam de forma adequada dentro da empresa.", listOf("Sempre", "Frequentemente", "Às vezes", "Raramente", "Nunca")),
        Pair("Tenho ciência sobre as metas e os resultados esperados de mim.", listOf("Sempre", "Frequentemente", "Às vezes", "Raramente", "Nunca")),
        // Relação com a Liderança
        Pair("Minha liderança demonstra interesse pelo meu bem-estar no trabalho.", listOf("Sempre", "Frequentemente", "Às vezes", "Raramente", "Nunca")),
        Pair("Minha liderança está disponível para me ouvir quando necessário.", listOf("Sempre", "Frequentemente", "Às vezes", "Raramente", "Nunca")),
        Pair("Me sinto confortável para reportar problemas ou dificuldades ao meu líder.", listOf("Sempre", "Frequentemente", "Às vezes", "Raramente", "Nunca")),
        Pair("Minha liderança reconhece minhas entregas e esforços.", listOf("Sempre", "Frequentemente", "Às vezes", "Raramente", "Nunca")),
        Pair("Estou confiante e tranquila(o) na relação com minha liderança.", listOf("Sempre", "Frequentemente", "Às vezes", "Raramente", "Nunca"))
    )

    val respostas = remember { mutableStateListOf(*Array(perguntas.size) { "" }) }
    var showDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "AUTOAVALIAÇÃO",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        perguntas.forEachIndexed { idx, (pergunta, opcoes) ->
            Text(
                text = pergunta,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            opcoes.forEach { opcao ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp)
                ) {
                    RadioButton(
                        selected = respostas[idx] == opcao,
                        onClick = { respostas[idx] = opcao }
                    )
                    Text(text = opcao)
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                scope.launch {
                    val autoAvaliacao = calcularIndices(respostas)
                    database.autoAvaliacaoDao().inserir(autoAvaliacao)
                    showDialog = true
                }
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text("Enviar", fontSize = 18.sp)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate("home") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text("Voltar para Home", fontSize = 16.sp)
        }
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text("Checkin Realizado com Sucesso!") },
            text = { Text("Seu checkin foi registrado. O que deseja fazer agora?") },
            confirmButton = {
                Button(
                    onClick = {
                        showDialog = false
                        navController.navigate("home")
                    }
                ) {
                    Text("Ir para Home")
                }
            },
            dismissButton = {
                Button(
                    onClick = {
                        showDialog = false
                        navController.navigate("login") // ajuste a rota se necessário
                    }
                ) {
                    Text("Sair (Logout)")
                }
            }
        )
    }
}

// Preview para AutoAvaliacaoScreen
//@Preview(showBackground = true)
//@Composable
//fun AutoAvaliacaoScreenPreview() {
//    AutoAvaliacaoScreen(navController = object : NavController(null) {})
//}
