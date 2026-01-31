package com.example.remedialucp2_006.view.uiController

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.remedialucp2_006.room.Buku
import com.example.remedialucp2_006.viewmodel.provider.HomeViewModel

@Composable
fun HalamanHome(
    viewModel: HomeViewModel,
    onTambah: () -> Unit,
    onDetail: (Buku) -> Unit
) {
    val daftarBuku by viewModel.daftarBuku.collectAsState()

    Scaffold(
        topBar = { AppBar(judul = "Daftar Buku") },
        floatingActionButton = {
            FloatingActionButton(onClick = onTambah) {
                Icon(Icons.Default.Add, contentDescription = null)
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.padding(padding)) {
            items(daftarBuku) { buku ->
                ListItem(
                    headlineText = { Text(buku.judul) },
                    modifier = Modifier.clickable { onDetail(buku) }
                )
                Divider()
            }
        }
    }
}
