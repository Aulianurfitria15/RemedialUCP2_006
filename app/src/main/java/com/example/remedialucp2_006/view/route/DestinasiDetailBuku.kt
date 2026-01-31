package com.example.remedialucp2_006.view.route

object DestinasiDetailBuku : DestinasiNavigasi {
    override val route = "detail"
    override val judul = "Detail Buku"

    const val bukuIdArg = "bukuId"
    val routeWithArg = "$route/{$bukuIdArg}"
}
