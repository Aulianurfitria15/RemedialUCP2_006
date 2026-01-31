package com.example.remedialucp2_006.room

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface AuditLogDao {

    @Insert
    suspend fun insert(log: AuditLog)
}
