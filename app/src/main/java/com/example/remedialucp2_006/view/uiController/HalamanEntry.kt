package com.example.remedialucp2_006.view.uiController

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.remedialucp2_006.viewmodel.provider.EntryViewModel

@Composable
fun HalamanEntry(
    navController: NavController,
    viewModel: EntryViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    var judul by remember { mutableStateOf("") }
    var penulis by remember { mutableStateOf("") }
    var tahun by remember { mutableStateOf("") }

    Scaffold { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp)) {

            Text("Tambah Buku", style = MaterialTheme.typography.headlineMedium)

            OutlinedTextField(
                value = judul,
                onValueChange = { judul = it },
                label = { Text("Judul Buku") },
                modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp)
            )

            OutlinedTextField(
                value = penulis,
                onValueChange = { penulis = it },
                label = { Text("Penulis") },
                modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp)
            )

            OutlinedTextField(
                value = tahun,
                onValueChange = { tahun = it },
                label = { Text("Tahun") },
                modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp)
            )

            Button(
                onClick = {
                    viewModel.tambahBuku(judul, penulis, tahun)
                    navController.popBackStack()
                },
                modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
            ) {
                Text("Simpan")
            }
        }
    }
}