package com.example.balancehealth.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "auto_avaliacao")
data class AutoAvaliacao(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val data: Date = Date(),
    val sexo: String,
    val sentimentoHoje: String,
    val cargaTrabalho: String,
    val impactoQualidadeVida: String,
    val horasExtras: String,
    val sintomasPsicologicos: String,
    val impactoProdutividade: String,
    val relacionamentoSetor: String,
    val relacionamentoOutrosSetores: String,
    val respeito: String,
    val relacionamentoEquipe: String,
    val liberdadeExpressao: String,
    val valorizacao: String,
    val cooperacao: String,
    val feedbacks: String,
    val comunicacaoAberta: String,
    val circulacaoInformacoes: String,
    val cienciaMetas: String,
    val interesseLideranca: String,
    val disponibilidadeLider: String,
    val confortoReportarProblemas: String,
    val reconhecimentoLider: String,
    val confiancaLider: String,

    // Campos calculados
    var indiceRelacionamento: Double = 0.0,
    var indiceComunicacao: Double = 0.0,
    var indiceRelacaoLideranca: Double = 0.0,
    var indiceBurnout: Double = 0.0,
    var classificacaoRisco: String = ""
)
