package com.example.balancehealth.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface AutoAvaliacaoDao {
    @Insert
    suspend fun inserir(autoAvaliacao: AutoAvaliacao)

    @Query("SELECT * FROM auto_avaliacao ORDER BY data DESC")
    fun obterTodasAvaliacoes(): Flow<List<AutoAvaliacao>>

    @Query("SELECT * FROM auto_avaliacao ORDER BY data DESC LIMIT 1")
    suspend fun obterUltimaAvaliacao(): AutoAvaliacao?
}
