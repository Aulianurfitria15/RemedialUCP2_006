package com.example.remedialucp2_006.viewmodel.provider

import com.example.remedialucp2_006.repositori.OfflineRepositoriBuku
import com.example.remedialucp2_006.repositori.RepositoriBuku
import com.example.remedialucp2_006.room.DatabaseBuku

class PenyediaViewModel(
    private val database: DatabaseBuku
) {

    private val repositoriBuku: RepositoriBuku by lazy {
        OfflineRepositoriBuku(
            database.bukuDao(),
            database.auditLogDao()
        )
    }

    fun provideHomeViewModel(): HomeViewModel {
        return HomeViewModel(repositoriBuku)
    }

    fun provideEntryViewModel(): EntryViewModel {
        return EntryViewModel(repositoriBuku)
    }

    fun provideDetailViewModel(): DetailViewModel {
        return DetailViewModel(repositoriBuku)
    }

    fun provideEditViewModel(): EditViewModel {
        return EditViewModel(
            repositoriBuku,
            database.auditLogDao()
        )
    }
}
