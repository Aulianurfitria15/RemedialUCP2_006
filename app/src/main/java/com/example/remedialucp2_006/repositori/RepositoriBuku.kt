package com.example.remedialucp2_006.repositori

import com.example.remedialucp2_006.room.Buku
import kotlinx.coroutines.flow.Flow

interface RepositoriBuku {

    fun getAllBuku(): Flow<List<Buku>>

    fun getBukuById(id: Int): Flow<Buku?>

    suspend fun insert(buku: Buku)

    suspend fun update(buku: Buku)

    suspend fun softDelete(buku: Buku)
}