package com.example.remedialucp2_006.viewmodel.provider

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.remedialucp2_006.repositori.RepositoriBuku
import com.example.remedialucp2_006.room.Buku
import kotlinx.coroutines.launch

class DetailViewModel(
    private val repo: RepositoriBuku
) : ViewModel() {

    fun hapus(buku: Buku) {
        viewModelScope.launch {
            repo.delete(buku)
        }
    }
}
