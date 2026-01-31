package com.example.remedialucp2_006.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pengarang")
data class Pengarang(
    @PrimaryKey(autoGenerate = true)
    val idPengarang: Int = 0,
    val nama: String
)
