package com.example.remedialucp2_006.room

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "kategori",
    foreignKeys = [
        ForeignKey(
            entity = Kategori::class,
            parentColumns = ["idKategori"],
            childColumns = ["parentId"],
            onDelete = ForeignKey.RESTRICT
        )
    ]
)
data class Kategori(
    @PrimaryKey(autoGenerate = true)
    val idKategori: Int = 0,

    val namaKategori: String,
    val parentId: Int? = null,
    val isDeleted: Boolean = false
)
