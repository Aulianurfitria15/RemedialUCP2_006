package com.example.remedialucp2_006.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface BukuDao {

    @Query("SELECT * FROM buku WHERE isDeleted = 0")
    fun getAll(): Flow<List<Buku>>

    @Query("SELECT * FROM buku WHERE idBuku = :id")
    fun getById(id: Int): Flow<Buku?>

    @Query("SELECT * FROM buku WHERE idBuku = :id")
    suspend fun getByIdOnce(id: Int): Buku?

    @Insert
    suspend fun insert(buku: Buku)

    @Update
    suspend fun update(buku: Buku)

    @Query("UPDATE buku SET isDeleted = 1 WHERE idBuku = :id")
    suspend fun softDelete(id: Int)
}
