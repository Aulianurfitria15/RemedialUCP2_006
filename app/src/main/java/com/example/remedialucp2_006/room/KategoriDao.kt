package com.example.remedialucp2_006.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface KategoriDao {

    @Query("SELECT * FROM kategori WHERE parentId = :parentId")
    suspend fun getSubKategori(parentId: Int): List<Kategori>

    @Insert
    suspend fun insert(kategori: Kategori)

    @Query("UPDATE kategori SET isDeleted = 1 WHERE idKategori = :id")
    suspend fun softDelete(id: Int)
}
