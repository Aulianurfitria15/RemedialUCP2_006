package com.example.remedialucp2_006.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Buku::class, Kategori::class, Pengarang::class, AuditLog::class],
    version = 1
)
abstract class DatabaseBuku : RoomDatabase() {

    abstract fun bukuDao(): BukuDao
    abstract fun kategoriDao(): KategoriDao
    abstract fun auditLogDao(): AuditLogDao
}
