package com.example.remedialucp2_006.view.route

object DestinasiEditBuku : DestinasiNavigasi {
    override val route = "edit"
    override val judul = "Edit Buku"

    const val bukuIdArg = "bukuId"
    val routeWithArg = "$route/{$bukuIdArg}"
}
