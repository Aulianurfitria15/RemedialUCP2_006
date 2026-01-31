package com.example.remedialucp2_006.viewmodel.provider

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.remedialucp2_006.repositori.RepositoriBuku
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

class HomeViewModel(
    private val repo: RepositoriBuku
) : ViewModel() {

    val daftarBuku = repo.getAllBuku()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())
}
