package com.example.remedialucp2_006.repositori

import com.example.remedialucp2_006.room.AuditLog
import com.example.remedialucp2_006.room.AuditLogDao
import com.example.remedialucp2_006.room.Buku
import com.example.remedialucp2_006.room.BukuDao
import kotlinx.coroutines.flow.Flow

class OfflineRepositoriBuku(
    private val bukuDao: BukuDao,
    private val auditLogDao: AuditLogDao
) : RepositoriBuku {

    override fun getAllBuku(): Flow<List<Buku>> =
        bukuDao.getAll()

    override fun getBukuById(id: Int): Flow<Buku?> =
        bukuDao.getById(id)

    override suspend fun insert(buku: Buku) {
        bukuDao.insert(buku)

        auditLogDao.insert(
            AuditLog(
                tableName = "buku",
                dataLama = "",
                dataBaru = buku.toString()
            )
        )
    }

    override suspend fun update(buku: Buku) {
        val lama = bukuDao.getByIdOnce(buku.idBuku)

        bukuDao.update(buku)

        auditLogDao.insert(
            AuditLog(
                tableName = "buku",
                dataLama = lama.toString(),
                dataBaru = buku.toString()
            )
        )
    }

    override suspend fun softDelete(buku: Buku) {
        bukuDao.softDelete(buku.idBuku)

        auditLogDao.insert(
            AuditLog(
                tableName = "buku",
                dataLama = buku.toString(),
                dataBaru = "SOFT DELETE"
            )
        )
    }
}
