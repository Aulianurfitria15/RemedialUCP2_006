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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.remedialucp2_006.viewmodel.provider.EditViewModel

@Composable
fun HalamanEditBuku(
    id: String,
    navController: NavController,
    viewModel: EditViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    val buku = viewModel.getBuku(id).collectAsState(initial = null)

    var judul by remember { mutableStateOf("") }
    var penulis by remember { mutableStateOf("") }
    var tahun by remember { mutableStateOf("") }

    buku.value?.let { data ->
        LaunchedEffect(data) {
            judul = data.judul
            penulis = data.penulis
            tahun = data.tahun
        }
    }

    Scaffold { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp)) {

            Text("Edit Buku", style = MaterialTheme.typography.headlineMedium)

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
                    viewModel.updateBuku(id, judul, penulis, tahun)
                    navController.popBackStack()
                },
                modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
            ) {
                Text("Update")
            }
        }
    }
}