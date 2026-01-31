package com.example.remedialucp2_006.viewmodel.provider

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.remedialucp2_006.repositori.RepositoriBuku
import com.example.remedialucp2_006.room.AuditLog
import com.example.remedialucp2_006.room.AuditLogDao
import com.example.remedialucp2_006.room.Buku
import kotlinx.coroutines.launch

class EditViewModel(
    private val repo: RepositoriBuku,
    private val auditLogDao: AuditLogDao
) : ViewModel() {

    fun updateBuku(
        bukuLama: Buku,
        judulBaru: String,
        kategoriIdBaru: Int?
    ) {
        // validasi dasar sesuai soal
        if (judulBaru.isBlank()) return

        val bukuBaru = bukuLama.copy(
            judul = judulBaru,
            kategoriId = kategoriIdBaru
        )

        viewModelScope.launch {
            // update data
            repo.insert(bukuBaru)

            // audit log before-after
            auditLogDao.insert(
                AuditLog(
                    tableName = "buku",
                    dataLama = bukuLama.toString(),
                    dataBaru = bukuBaru.toString()
                )
            )
        }
    }
}
