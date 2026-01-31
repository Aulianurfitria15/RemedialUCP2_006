package com.example.remedialucp2_006.view.uiController

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.remedialucp2_006.view.route.DestinasiEditBuku
import com.example.remedialucp2_006.viewmodel.provider.DetailViewModel

@Composable
fun HalamanDetailBuku(
    id: String,
    navController: NavController,
    viewModel: DetailViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    val buku = viewModel.getBuku(id).collectAsState(initial = null)

    buku.value?.let { data ->
        Scaffold(
            floatingActionButton = {
                FloatingActionButton(onClick = {
                    navController.navigate("${DestinasiEditBuku.route}/${data.id}")
                }) {
                    Icon(Icons.Default.Edit, contentDescription = "Edit Buku")
                }
            }
        ) { padding ->
            Column(modifier = Modifier.padding(padding).padding(16.dp)) {
                Text("Detail Buku", style = MaterialTheme.typography.headlineMedium)

                Spacer(modifier = Modifier.height(16.dp))

                Text("Judul: ${data.judul}", style = MaterialTheme.typography.titleMedium)
                Text("Penulis: ${data.penulis}")
                Text("Tahun: ${data.tahun}")
            }
        }
    }
}