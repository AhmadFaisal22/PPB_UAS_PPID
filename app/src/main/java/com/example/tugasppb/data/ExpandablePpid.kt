package com.example.tugasppb.data

import java.util.*
import kotlin.collections.ArrayList


object ExpandablePpid {
    val data: HashMap<String, ArrayList<String>>
        get() {
            val expandableListDetail =
                HashMap<String, ArrayList<String>>()
            val infoPublick: ArrayList<String> =
                ArrayList()
            infoPublick.add("Informasi Berkala")
            infoPublick.add("Informasi Serta Merta")
            infoPublick.add("Informasi Setiap Saat")
            infoPublick.add("Informasi Dikecualikan")
            val layanan: ArrayList<String> =
                ArrayList()
            layanan.add("Mekanisme Permohonan Informasi")
            layanan.add("Keberatan Informasi")
            layanan.add("Mekanisme Pengajuan Penyelesaian Sengketa Informasi")
            layanan.add("Tata Cara Pengaduan Perilaku ASN")
            expandableListDetail["Info Public"] = infoPublick
            expandableListDetail["Layanan"] = layanan
            return expandableListDetail
        }
}