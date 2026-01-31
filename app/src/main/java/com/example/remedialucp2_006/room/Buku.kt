package com.example.remedialucp2_006.room

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "buku",
    foreignKeys = [
        ForeignKey(
            entity = Kategori::class,
            parentColumns = ["idKategori"],
            childColumns = ["kategoriId"],
            onDelete = ForeignKey.SET_NULL
        )
    ]
)
data class Buku(
    @PrimaryKey(autoGenerate = true)
    val idBuku: Int = 0,

    val judul: String,
    val dipinjam: Boolean = false,

    val kategoriId: Int? = null,

    val isDeleted: Boolean = false
)
