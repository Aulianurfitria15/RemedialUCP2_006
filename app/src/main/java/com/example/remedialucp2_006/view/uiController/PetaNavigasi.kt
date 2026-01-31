package com.example.remedialucp2_006.view.uiController

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.remedialucp2_006.view.route.DestinasiDetailBuku
import com.example.remedialucp2_006.view.route.DestinasiEditBuku
import com.example.remedialucp2_006.view.route.DestinasiEntry
import com.example.remedialucp2_006.view.route.DestinasiHome
import com.example.remedialucp2_006.viewmodel.provider.PenyediaViewModel

@Composable
fun PetaNavigasi(
    navController: NavHostController,
    penyedia: PenyediaViewModel
) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route
    ) {

        composable(DestinasiHome.route) {
            HalamanHome(
                viewModel = penyedia.provideHomeViewModel(),
                onTambah = {
                    navController.navigate(DestinasiEntry.route)
                },
                onDetail = { buku ->
                    navController.navigate(
                        "${DestinasiDetailBuku.route}/${buku.idBuku}"
                    )
                }
            )
        }

        composable(DestinasiEntry.route) {
            HalamanEntry(
                viewModel = penyedia.provideEntryViewModel(),
                onSelesai = { navController.popBackStack() }
            )
        }

        composable(
            route = DestinasiDetailBuku.routeWithArg,
            arguments = listOf(navArgument(DestinasiDetailBuku.bukuIdArg) {
                type = NavType.IntType
            })
        ) {
            // nanti ambil buku dari ViewModel
        }

        composable(
            route = DestinasiEditBuku.routeWithArg,
            arguments = listOf(navArgument(DestinasiEditBuku.bukuIdArg) {
                type = NavType.IntType
            })
        ) {
            // edit screen
        }
    }
