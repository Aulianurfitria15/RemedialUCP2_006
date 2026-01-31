package com.example.remedialucp2_006.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "audit_log")
data class AuditLog(
    @PrimaryKey(autoGenerate = true)
    val idLog: Int = 0,

    val tableName: String,
    val dataLama: String,
    val dataBaru: String,
    val waktu: Long = System.currentTimeMillis()
)

